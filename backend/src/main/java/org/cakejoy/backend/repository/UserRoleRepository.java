package org.cakejoy.backend.repository;

import org.cakejoy.backend.api.external.UsersRoleDTO;
import org.cakejoy.backend.api.internal.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    @Query("SELECT new org.cakejoy.backend.api.external.UsersRoleDTO(ur.id, ur.name) FROM UserRole ur WHERE ur.id = :id")
    UsersRoleDTO findNameById(@Param("id") int id);
}
