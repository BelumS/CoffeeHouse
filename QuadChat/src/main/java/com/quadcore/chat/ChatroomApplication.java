package com.quadcore.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //combination of @Configuration, @EnableAutoConfiguration, @EnableWebMvc, and @ComponentScan
public class ChatroomApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(ChatroomApplication.class, args);
	}

	//private static final Logger logger = LoggerFactory.getLogger(ChatroomApplication.class);
	
	/*@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	/Used for Testing the JPA
	@Override
	@Transactional
	public void run(String... args) throws Exception 
	{
		//save a few Users
		final Role roleA = new Role("USER");
		final Role roleB = new Role("ADMIN");
		
		userRepository.save(new HashSet<User>() {{
			add(new User("belum24", "belum@gmail.com", "belum123", true, new HashSet<Role>() {{
				add(roleA);
				add(roleB);
			}}));
			
			add(new User("coffeebean13", "beans@yahoo.com", "beans111", true, new HashSet<Role>() {{
				add(roleB);
			}}));
		}});
		
		//Fetch all users
		for(User users : userRepository.findAll())
		{
			logger.info(users.toString());
		}
		
		//save a few User roles
		final User userA = new User("userA", "userA@email.com", "1234");
		final User userB = new User("userB", "userB@outlook.com", "5678");
		
		roleRepository.save(new HashSet<Role>() {{
			add(new Role("MANAGER", new HashSet<User>() {{
				add(userA);
			}}));
			
			add(new Role("DBA", new HashSet<User>() {{
				add(userB);
			}}));
		}});
		
		//fetch all Roles
		for(Role role : roleRepository.findAll())
		{
			logger.info(role.toString());
		}
	}*/
}
