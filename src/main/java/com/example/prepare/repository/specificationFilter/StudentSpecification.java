package com.example.prepare.repository.specificationFilter;

import com.example.prepare.entity.Student;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class StudentSpecification implements Specification<Student> {
    private final Student filter;

    public StudentSpecification(Student filter) {
        super();
        this.filter = filter;
    }

    @Override
    public Specification<Student> and(Specification<Student> other) {
        return Specification.super.and(other);
    }

    @Override
    public Specification<Student> or(Specification<Student> other) {
        return Specification.super.or(other);
    }

    @Override
    public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate p = criteriaBuilder.conjunction();
        if (filter.getName() != null) {
            p.getExpressions().add(criteriaBuilder.equal(root.get("name"), filter.getName()));
        }
        if (filter.getCollege() != null) {
            p.getExpressions().add(criteriaBuilder.equal(root.get("college").get("id"), filter.getCollege().getId()));
        }
        if(filter.getAge()!=0){
            p.getExpressions().add(criteriaBuilder.equal(root.get("age"),filter.getAge()));
        }
        return p;
    }
}
