package com.example.demojpa.repository;

import com.example.demojpa.entity.Emp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepositoryExtensionsKt;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

//gives you predefined methods to access data from database

public interface EmpRepository extends CrudRepository<Emp,Long> {
//Create Update Delete
    @Query(value = "select * from emp where name like :name",nativeQuery = true)
    List<Emp> findEmpByName(@Param("name")String name);

    @Query(value ="select * from emp where salary >= :salary",nativeQuery = true)
    List<Emp> findSalaryGreater(@Param("salary") Double salary);
}
