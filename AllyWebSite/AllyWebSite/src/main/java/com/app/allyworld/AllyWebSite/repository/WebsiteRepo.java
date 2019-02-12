package com.app.allyworld.AllyWebSite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.allyworld.AllyWebSite.enitity.LoginCredentials;

@Repository
public interface WebsiteRepo extends JpaRepository<LoginCredentials, Integer>{

}
