package repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemoryMemberRespository;

public class MemoryMemberRespositoryTest {
    


    MemoryMemberRespository respository = new MemoryMemberRespository();
    
    @AfterEach
    public void afterEach(){
        respository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member .setName("spring");

        respository.save(member);

        Member result = respository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
                // System.out.println("result = " + (result == member));


    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        respository.save(member1);
        
        Member member2 = new Member();
        member2.setName("spring2");
        respository.save(member2);
  
        Member result = respository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);

        }



    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        respository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        respository.save(member2);
        List<Member> result = respository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
