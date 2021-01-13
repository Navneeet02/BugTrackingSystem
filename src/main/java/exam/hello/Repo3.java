package exam.hello;

import java.util.List;

import javax.persistence.Transient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RequestParam;


@Repository
public interface Repo3 extends JpaRepository<Bugs, Integer> {
	@Transactional
	@Query(value="Select * from bug where testerid = :b",nativeQuery=true)
	public List<Bugs> getBugsTester(@Param("b")Integer testerid ); 

	@Transactional
	@Query(value="Select * from bug where developerid = :b",nativeQuery=true)
	public List<Bugs> getDeveloperBugs(@Param("b")Integer testerid ); 
	
	@Transactional
	@Modifying
    @Query(value="Update bug b set b.review=:r where b.bugid=:i",nativeQuery = true )
    void updateReview(@Param("r")String r,@Param("i") Integer i);

}