package com.akash.gp_ledger;

import org.springframework.boot.SpringApplication;

public class TestGpLedgerApplication {

	public static void main(String[] args) {
		SpringApplication.from(GpLedgerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
