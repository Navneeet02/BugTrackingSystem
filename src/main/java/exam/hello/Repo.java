package exam.hello;



import javax.persistence.Transient;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface Repo extends JpaRepository<Tester, Integer> {

	@Transactional
	 @Modifying
	 @Query(value="Update tester t  set t.testerpwd=:p where t.testerid=:i" ,nativeQuery = true)
	 void updatePassword(@Param("p")String p,@Param("i") Integer i);
	@Transactional
     @Modifying
	 @Query(value="Update tester t set t.email=:p where t.testerid=:i",nativeQuery = true )
	 void updateEmail(@Param("p")String p,@Param("i") Integer i);
	@Transactional
	 @Modifying
	 @Query(value="Update tester t  set t.testermobile=:p where t.testerid=:i",nativeQuery = true )
	 void updateMobile(@Param("p")String p,@Param("i") Integer i);

}