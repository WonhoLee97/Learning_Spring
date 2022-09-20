package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.sql.ConnectionEvent;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class JdbcMemberRepository implements MemberRepository {

    private final DataSource dataSource;

    public JdbcMemberRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        //dataSource.getConnection(); //진짜 DB랑 연결된 것이랑 연결
    }

    @Override
    public Member save(Member member) {
        String sql = "insert into memeber(name) values(?)";
        Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,member.getName());

        pstmt.executeUpdate();


        return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        return null;
    }
}
