package org.example.init;

import org.example.Enums.Category;
import org.example.Enums.Engine;
import org.example.Enums.RoleEnum;
import org.example.Enums.Transmission;
import org.example.dtos.*;
import org.example.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private RoleService roleService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private OfferService offerService;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() throws IOException {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterday = LocalDateTime.now().minusDays(1);

        BigDecimal price1 = new BigDecimal(14000000);
        BigDecimal price2 = new BigDecimal(90000000);

        UUID uuid1 = UUID.randomUUID();
        UUID uuid2 = UUID.randomUUID();

        BrandDto brand1 = new BrandDto(uuid1, "BWV", now, yesterday);
        BrandDto brand2 = new BrandDto(uuid2, "Mazda", now, yesterday);

        brand1 = brandService.registerBrand(brand1);
        brand2 = brandService.registerBrand(brand2);

        UUID uuid3 = UUID.randomUUID();
        UUID uuid4 = UUID.randomUUID();


        RoleDto roles1 = new RoleDto(uuid3, RoleEnum.User);
        RoleDto roles2 = new RoleDto(uuid4, RoleEnum.Admin);

        roles1 = roleService.registerRole(roles1);
        roles2 = roleService.registerRole(roles2);

        UUID uuid5 = UUID.randomUUID();
        UUID uuid6 = UUID.randomUUID();

        UsersDto user1 = new UsersDto(uuid5,roles1, "userJohn", "passUser", "John",
                "Pack", true, "urlImage_1", now, yesterday);

        UsersDto user2 = new UsersDto(uuid6, roles2, "adminTifa", "passAdmin", "Tifa",
                "Sharikova", true, "urlImage_2", now, yesterday);

        user1 = usersService.registerUser(user1);
        user2 = usersService.registerUser(user2);

        UUID uuid7 = UUID.randomUUID();
        UUID uuid8 = UUID.randomUUID();


        ModelDto model1 = new ModelDto(uuid7, brand2,"CX-5", Category.CAR, "image_url_1", 2001, 2023, now, yesterday);
        ModelDto model2 = new ModelDto(uuid8, brand1, "I-8", Category.BUS, "image_url_2", 2020, 2030, now, yesterday);

        model1 = modelService.registerModel(model1);
        model2 = modelService.registerModel(model2);

        UUID uuid9 = UUID.randomUUID();
        UUID uuid10 = UUID.randomUUID();

        OfferDto offer1 = new OfferDto(uuid9, model1,user1,"cool car", Engine.ELECTRIC, "image_url_1", 1200, price1, Transmission.AUTOMATIC, 2009,
                now, yesterday);

        OfferDto offer2 = new OfferDto(uuid10, model2, user2,"faster car", Engine.ELECTRIC, "image_url_2", 9000, price2, Transmission.AUTOMATIC, 2020,
                now, yesterday);

        offer1 = offerService.registerOffer(offer1);
        offer2 = offerService.registerOffer(offer2);

        System.out.println(brand1);
        System.out.println(brand2);

        System.out.println(roles1);
        System.out.println(roles2);

        System.out.println(user1);
        System.out.println(user2);

        System.out.println(model1);
        System.out.println(model2);

        System.out.println(offer1);
        System.out.println(offer2);

//        System.out.println("after del role");

//        brandService.deleteBrand(brand1.getId());

//        modelService.deleteModel(model1.getId());

//        offerService.deleteOffer(offer1.getId());



//        System.out.println(brand1);
//        System.out.println(brand2);
//
//        System.out.println(roles1);
//        System.out.println(roles2);
//
//        System.out.println(user1);
//        System.out.println(user2);
//
//        System.out.println(model1);
//        System.out.println(model2);
//
//        System.out.println(offer1);
//        System.out.println(offer2);


    }
}
