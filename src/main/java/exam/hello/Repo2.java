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
public interface Repo2 extends JpaRepository<Developer, Integer> {
	@Transactional
	@Modifying
	 @Query(value="Update developer d set d.developerpwd=:p where d.developerid=:i",nativeQuery = true )
	 void updatePassword2(@Param("p")String p,@Param("i") Integer i);
	@Transactional
    @Modifying
	 @Query(value="Update developer d set d.email=:p where d.developerid=:i",nativeQuery = true )
	 void updateEmail2(@Param("p")String p,@Param("i") Integer i);
	 @Modifying
	 @Transactional
	 @Query(value="Update developer d  set d.developermobile=:p where d.developerid=:i",nativeQuery = true )
	 void updateMobile2(@Param("p")String p,@Param("i") Integer i);
	 
	 
}