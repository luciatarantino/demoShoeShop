package com.example.demoShoeShop;

import com.example.demoShoeShop.Utils.Md5;
import com.example.demoShoeShop.entities.Model;
import com.example.demoShoeShop.entities.Shoe;
import com.example.demoShoeShop.entities.User;
import com.example.demoShoeShop.repositories.ModelRepo;
import com.example.demoShoeShop.repositories.ShoeRepo;
import com.example.demoShoeShop.repositories.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoShoeShopApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(DemoShoeShopApplication.class);

	@Autowired
	ModelRepo modelRepo;
	@Autowired
	ShoeRepo shoeRepo;
	@Autowired
	UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(DemoShoeShopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Se mi vedi funziona il Logger");

		userRepo.save(new User("supermario", Md5.encrypt("caramella"), "Mario Rossi", "seller"));
		userRepo.save(new User("gigi86", Md5.encrypt("mortadella"), "Luigi Bianchi", "seller"));
		userRepo.save(new User("lucyInTheSky", Md5.encrypt("mandarino"), "Lucia Tarantino", "owner"));
		userRepo.save(new User("gianni90", Md5.encrypt("bacinella"), "Giovanni Verdi"));



		Model m1 = new Model(123456, "stivale", "FairPair", 50);
		Model m2 = new Model(456789, "ballerina", "FairPair", 50);
		Model m3 = new Model(123789, "trainer", "BailaMorena", 50);
		Model m4 = new Model(456123, "mocassino", "Yatta", 50);
		Model m5 = new Model(789654, "ciabatta", "Croco", 50);

		modelRepo.save(m1);
		modelRepo.save(m2);
		modelRepo.save(m3);
		modelRepo.save(m4);
		modelRepo.save(m5);

		shoeRepo.save(new Shoe(m1, "nero", 36,5));
		shoeRepo.save(new Shoe(m1, "nero", 37,8));
		shoeRepo.save(new Shoe(m1, "nero", 38,10));
		shoeRepo.save(new Shoe(m1, "nero", 39,10));
		shoeRepo.save(new Shoe(m1, "nero", 40,8));
		shoeRepo.save(new Shoe(m1, "nero", 41,5));
		shoeRepo.save(new Shoe(m1, "marrone", 36,5));
		shoeRepo.save(new Shoe(m1, "marrone", 37,8));
		shoeRepo.save(new Shoe(m1, "marrone", 38,10));
		shoeRepo.save(new Shoe(m1, "marrone", 39,10));
		shoeRepo.save(new Shoe(m1, "marrone", 40,8));
		shoeRepo.save(new Shoe(m1, "marrone", 41,5));

		shoeRepo.save(new Shoe(m2, "nero", 36,5));
		shoeRepo.save(new Shoe(m2, "nero", 37,8));
		shoeRepo.save(new Shoe(m2, "nero", 38,10));
		shoeRepo.save(new Shoe(m2, "nero", 39,10));
		shoeRepo.save(new Shoe(m2, "nero", 40,8));
		shoeRepo.save(new Shoe(m2, "nero", 41,5));
		shoeRepo.save(new Shoe(m2, "rosa antico", 36,5));
		shoeRepo.save(new Shoe(m2, "rosa antico", 37,8));
		shoeRepo.save(new Shoe(m2, "rosa antico", 38,10));
		shoeRepo.save(new Shoe(m2, "rosa antico", 39,10));
		shoeRepo.save(new Shoe(m2, "rosa antico", 40,8));
		shoeRepo.save(new Shoe(m2, "rosa antico", 41,5));
		shoeRepo.save(new Shoe(m2, "blu", 36,5));
		shoeRepo.save(new Shoe(m2, "blu", 37,8));
		shoeRepo.save(new Shoe(m2, "blu", 38,10));
		shoeRepo.save(new Shoe(m2, "blu", 39,10));
		shoeRepo.save(new Shoe(m2, "blu", 40,8));
		shoeRepo.save(new Shoe(m2, "blu", 41,5));

		shoeRepo.save(new Shoe(m3, "nero", 36,5));
		shoeRepo.save(new Shoe(m3, "nero", 37,8));
		shoeRepo.save(new Shoe(m3, "nero", 38,10));
		shoeRepo.save(new Shoe(m3, "nero", 39,10));
		shoeRepo.save(new Shoe(m3, "nero", 40,8));
		shoeRepo.save(new Shoe(m3, "nero", 41,5));
		shoeRepo.save(new Shoe(m3, "beige", 36,5));
		shoeRepo.save(new Shoe(m3, "beige", 37,8));
		shoeRepo.save(new Shoe(m3, "beige", 38,10));
		shoeRepo.save(new Shoe(m3, "beige", 40,8));
		shoeRepo.save(new Shoe(m3, "beige", 41,5));
		shoeRepo.save(new Shoe(m3, "bianco", 36,5));
		shoeRepo.save(new Shoe(m3, "bianco", 37,8));
		shoeRepo.save(new Shoe(m3, "bianco", 38,10));
		shoeRepo.save(new Shoe(m3, "bianco", 39,10));
		shoeRepo.save(new Shoe(m3, "bianco", 40,8));
		shoeRepo.save(new Shoe(m3, "bianco", 41,5));

		shoeRepo.save(new Shoe(m4, "blu", 33,3));
		shoeRepo.save(new Shoe(m4, "marrone", 40,5));


		log.info("saved shoes in DB");
	}
}
