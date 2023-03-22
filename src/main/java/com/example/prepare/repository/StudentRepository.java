package com.example.prepare.repository;

import com.example.prepare.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

    List<Student> getStudentsByAgeBetween(int min, int max);

    @Query(value = "from Student where name = :name")
    public List<Student> findByName(String name);

    @Modifying
    // must have @Modifying & @Transactional
    // return void or int
    @Query("update Student set Info = :info where id = :id")
    public int updateInfoById(String info, long id);

    public List<Student> findByCollege_Id(long id);

//     native
//    @Query（value="select * from user u, town t where u.id = t.id and t.place = ?1", nativeQuery = true）

//    @Query(value = "from User u where u.username like %:username%")
//    List<User> findByNameLike(@Param("username")String username);
//
//    @Query("from User u")
//    Page<User> findAllPage(Pageable pageable);
}
