package com.zqxxjs.idgenerator.demos.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class BasicController {

	private static volatile long currentMills = System.currentTimeMillis() / 1000;

	private static AtomicLong baseId = new AtomicLong(currentMills * 100000000);

	@GetMapping("nextId")
	public Long nextId() {

		if (System.currentTimeMillis() / 1000 != currentMills) {
			currentMills = System.currentTimeMillis() / 1000;
			baseId = new AtomicLong(currentMills * 100000000);
		}
		return baseId.incrementAndGet();
	}
}
