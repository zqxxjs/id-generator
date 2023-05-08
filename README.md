This is a simple and reliable ID generator. 100 million unique IDs can be generated per second, which can be stored as mysql bigint type. Its principle is very simple, the key code does not exceed 10 lines, and it can be read in 2 minutes.

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
