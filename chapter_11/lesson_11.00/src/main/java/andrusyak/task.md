Есть следующий код:

    public interface Storage {
    	void add(User user);
    }


    public class MemoryStorage implements Storage {
        ArrayList<User> users;
    
        public MemoryStorage() {
            this.users = new ArrayList<>();
        }
    
        @Override
        public void add(User user) {
            this.users.add(user);
        }
    }


	public class UserStorage {
	    private final Storage storage;
	
	    public UserStorage(final Storage storage) {
	        this.storage = storage;
	    }
	
	    public void add(User user) {
	        this.storage.add(user);
	    }
	}

##Чтобы создать spring beans: 
####1. Только с помощью Annotations и java

Нужно создать класс что описывает контекст

	@Configuration
	public class AppContext {
		@Bean
		MemoryStorage memoryStorage() {
			return new MemoryStorage();
		}

		@Bean
		UserStorage userStorage() {
			return new UserStorage(memoryStorage());
		}
	}
Использовать так:

	ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
	UserStorage storage = context.getBean(UserStorage.class);

####2. С помощью файла spring-context.xml

Описать в файле наши бины:

	ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
	UserStorage storage = context.getBean(UserStorage.class);

Использовать так:

	ApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
	UserStorage storage = context.getBean(UserStorage.class);

####3. Файла xml и Annotations

указать в файле где искать наши бины 

	<context:component-scan base-package="andrusyak"/>

а в самых классах описать с помощью аннотаций

		@Component
		public class MemoryStorage implements Storage {
			ArrayList<User> users;
		
		    public MemoryStorage() {
		        this.users = new ArrayList<>();
		    }
		
		    @Override
		    public void add(User user) {
		        this.users.add(user);
		    }
		}

		@Component
		public class UserStorage {
		    private final Storage storage;
		
		    @Autowired
		    public UserStorage(final Storage storage) {
		        this.storage = storage;
		    }
		
		    public void add(User user) {
		        this.storage.add(user);
		    }
		}