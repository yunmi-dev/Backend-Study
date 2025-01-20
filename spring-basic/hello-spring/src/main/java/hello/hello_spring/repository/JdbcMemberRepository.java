package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// 데이터를 실제 DB에 저장하는 방식 -> 애플리케이션 종료돼도 데이터 유지

public class JdbcMemberRepository implements MemberRepository {

    // DB에 붙으려면 데이터 소스라는 게 필요함
    private final DataSource dataSource; // DataSource는 데이터베이스 연결을 관리하는 객체

    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    } // 생성자로 DataSource 주입받음

    @Override
    public Member save(Member member) {
        String sql = "insert into member(name) values(?)"; // SQL 쿼리 (?는 나중에 채워질 마라미터)

        Connection conn = null;         // DB 연결 담당
        PreparedStatement pstmt = null; // SQL 쿼리 실행하기 위한 객체
        ResultSet rs = null;            // 쿼리 실행결과 담는 객체

        try {
            conn = getConnection(); // DB 연결을 가져옴
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // SQL 쿼리 준비 && RETURN_GENERATED_KEYS로 생성된 키값 받을 수 있게 설정함

            pstmt.setString(1, member.getName());
            // ? 에 실제 값(회원의 name)을 설정함

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            // 쿼리 실행하고, 생성된 키 값 받아옴

            if (rs.next()) { // ResultSet에서 다음 row로 이동 (있으면 true, 없으면 false)
                member.setId(rs.getLong(1));
            } else {
                throw new SQLException("id 조회 실패");
            }
            return member;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<Member> findById(Long id) {
        String sql = "select * from member where id = ?";
        // SQL 쿼리 준비

        Connection conn = null;         // Connection 얻기
        PreparedStatement pstmt = null; // PreparedStatement 생성
        ResultSet rs = null;            // 쿼리 실행한 결과 ResultSet로 받기

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            /// SQL 인젝션 공격을 방지하고 쿼리를 안전하게 실행하기 위한 객체
            /// ?로 파라미터 표시하고, 나중에 setString() 등으로 값을 안전하게 설정

            rs = pstmt.executeQuery();
            // SELECT문 실행할 땐 executeQuery()
            // INSERT, UPDATE, DELETE문 실행할 땐 executeUpdate()

            if (rs.next()) {
                Member member = new Member();
                member.setId(rs.getLong("id")); /// DB에서 가져온 데이터(rs)는 그냥 raw한 데이터 -> 자바에서 쓸 수 있는 Member 객체로 만드는 과정 필요함
                /// rs.getLong("id")는 DB의 id 컬럼 값을 가져와서 Member 객체의 id로 설정하는 것
                member.setName(rs.getString("name"));
                return Optional.of(member);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs); /// DB 작업은 외부 자원 사용하는 거라, 사용 후에는 반드시 연결 닫아줘야 함.
            ///  안 닫으면 메모리 누수 발생 위험, DB 연결 계속 유지되어 부가적인 문제 위험
        }
    }

    @Override
    public Optional<Member> findByName(String name) {
        String sql = "select * from member where name = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection(); // 여기서 예외가 발생할 수 있음
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                Member member = new Member();
                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
                return Optional.of(member);
            }
            return Optional.empty();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs); // 리소스 정리
        }
    }

    @Override
    public List<Member> findAll() {
        String sql = "select * from member";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            List<Member> members = new ArrayList<>();
            while (rs.next()) {
                Member member = new Member();
                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
                members.add(member);
            }
            return members;
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
        // DataSource라는 커넥션 풀에서 미리 만들어준 연결 가져와서 DB와의 연결 설정함
    }

    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                close(conn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close(Connection conn) throws SQLException {
        DataSourceUtils.releaseConnection(conn, dataSource);
    }
}