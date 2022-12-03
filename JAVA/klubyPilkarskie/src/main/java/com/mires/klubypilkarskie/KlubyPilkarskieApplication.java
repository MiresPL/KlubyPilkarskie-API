package com.mires.klubypilkarskie;

import com.mires.klubypilkarskie.database.MysqlManager;
import com.mires.klubypilkarskie.helpers.KlubyManager;
import com.mires.klubypilkarskie.helpers.WypozyczeniaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class KlubyPilkarskieApplication {

	private static MysqlManager mysqlManager;
	private static WypozyczeniaManager wypozyczeniaManager;
	private static KlubyManager klubyManager;

	public static void main(String[] args) throws SQLException {
		mysqlManager = new MysqlManager();
		wypozyczeniaManager = new WypozyczeniaManager();
		klubyManager = new KlubyManager();
		SpringApplication.run(KlubyPilkarskieApplication.class, args);
	}

	public static MysqlManager getMysqlManager() {
		return mysqlManager;
	}

	public static WypozyczeniaManager getWypozyczeniaManager() {
		return wypozyczeniaManager;
	}

	public static KlubyManager getKlubyManager() {
		return klubyManager;
	}
}
