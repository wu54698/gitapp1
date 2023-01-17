package iSpancar.member.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import iSpancar.member.model.PermissionsOfPosition;

public interface PermissionsRepository extends JpaRepository<PermissionsOfPosition, String> {

}
