package org.example.init;

import org.example.models.enums.EngineType;
import org.example.models.enums.ModelCategory;
import org.example.models.enums.TransmissionType;
import org.example.models.enums.UserRoleType;
import org.example.services.*;
import org.example.services.dtos.input.*;
import org.example.services.dtos.output.BrandModelCountDTO;
import org.example.services.dtos.output.OfferDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private OfferService offerService;

    @Transactional
    public void createData() {

        BrandDTO brand1 = brandService.createCarBrand("Toyota");
        BrandDTO brand2 = brandService.createCarBrand("BMW");
        BrandDTO brand3 = brandService.createCarBrand("Audi");
        BrandDTO brand4 = brandService.createCarBrand("Mercedes-Benz");
        BrandDTO brand5 = brandService.createCarBrand("Ford");
        BrandDTO brand6 = brandService.createCarBrand("Honda");
        BrandDTO brand7 = brandService.createCarBrand("Nissan");
        BrandDTO brand8 = brandService.createCarBrand("Chevrolet");
        BrandDTO brand9 = brandService.createCarBrand("Volkswagen");
        BrandDTO brand10 = brandService.createCarBrand("Hyundai");
        BrandDTO brand11 = brandService.createCarBrand("Kia");
        BrandDTO brand12 = brandService.createCarBrand("Subaru");
        BrandDTO brand13 = brandService.createCarBrand("Lexus");
        BrandDTO brand14 = brandService.createCarBrand("Mazda");
        BrandDTO brand15 = brandService.createCarBrand("Porsche");
        BrandDTO brand16 = brandService.createCarBrand("Jaguar");
        BrandDTO brand17 = brandService.createCarBrand("Land Rover");
        BrandDTO brand18 = brandService.createCarBrand("Tesla");
        BrandDTO brand19 = brandService.createCarBrand("Acura");
        BrandDTO brand20 = brandService.createCarBrand("Volvo");

        String model1 = modelService.createCarModel(new ModelDTO("Camry", ModelCategory.CAR, "https://motor.ru/imgs/2023/03/27/07/5850601/1d98eae9560f5256bcaf929a3ea01d2877d989cc.jpg", 1990, 2021, brand1.getId())).getId();
        String model2 = modelService.createCarModel(new ModelDTO("X5", ModelCategory.TRUCK, "https://img.gazeta.ru/files3/136/17242136/bmw-x5m-1-pic_32ratio_1200x800-1200x800-99668.jpg", 2000, 2021, brand2.getId())).getId();
        String model3 = modelService.createCarModel(new ModelDTO("Corolla", ModelCategory.CAR, "https://avatars.mds.yandex.net/get-vertis-journal/4469561/cor-ex-046-233971.jpg_1682338161385/orig", 1995, 2021, brand1.getId())).getId();
        String model4 = modelService.createCarModel(new ModelDTO("A4", ModelCategory.CAR, "https://upload.wikimedia.org/wikipedia/commons/d/dc/Audi_A4_40_TFSI_B9_FL_Ibis_White_%281%29_%28cropped%29.jpg", 1998, 2021, brand3.getId())).getId();
        String model5 = modelService.createCarModel(new ModelDTO("E-Class", ModelCategory.CAR, "https://avatars.mds.yandex.net/get-verba/997355/2a00000176b7d3f6a4f92df665019bd8cd6f/cattouchret", 2001, 2021, brand4.getId())).getId();
        String model6 = modelService.createCarModel(new ModelDTO("Focus", ModelCategory.CAR, "https://s.auto.drom.ru/i24222/c/photos/fullsize/ford/focus/ford_focus_821500.jpg", 2003, 2021, brand5.getId())).getId();
        String model7 = (modelService.createCarModel(new ModelDTO("Civic", ModelCategory.CAR, "https://images.drive.ru/i/0/5d565b07ec05c48d4d000003", 2005, 2021, brand6.getId()))).getId();
        String model8 = modelService.createCarModel(new ModelDTO("Altima", ModelCategory.CAR, "https://avatars.mds.yandex.net/get-verba/997355/2a0000016eb273ff6dd826c5442bfb75440e/cattouch", 2008, 2021, brand7.getId())).getId();
        String model9 = modelService.createCarModel(new ModelDTO("Cruze", ModelCategory.CAR, "https://s.auto.drom.ru/i24194/c/photos/fullsize/chevrolet/cruze/chevrolet_cruze_56042.jpg", 2010, 2021, brand8.getId())).getId();
        String model10 = modelService.createCarModel(new ModelDTO("Jetta", ModelCategory.CAR, "https://images.drive.ru/i/0/5eccec94ec05c4f93d000007.jpg", 2012, 2021, brand9.getId())).getId();
        String model11 = modelService.createCarModel(new ModelDTO("Elantra", ModelCategory.CAR, "https://motor.ru/thumb/1500x0/filters:quality(75):no_upscale()/imgs/2023/02/27/10/5811664/99f11856ba3f414c4fa0d24329cb097cfed2d51d.jpg", 2014, 2021, brand10.getId())).getId();
        String model12 = modelService.createCarModel(new ModelDTO("Sorento", ModelCategory.CAR, "https://data.favorit-motors.ru/upload/iblock/aef/aefb35e85c3f6976c95a21870d787dd3.jpg", 2016, 2021, brand11.getId())).getId();
        String model13 = modelService.createCarModel(new ModelDTO("Outback", ModelCategory.CAR, "https://avatars.mds.yandex.net/get-autoru-vos/2127436/963825bd9ed0d030cbe07128799b0198/456x342n", 2018, 2021, brand12.getId())).getId();
        String model14 = modelService.createCarModel(new ModelDTO("RX 350", ModelCategory.CAR, "https://s.auto.drom.ru/i24234/c/photos/fullsize/lexus/rx350/lexus_rx350_897844.jpg", 2020, 2021, brand13.getId())).getId();
        String model15 = modelService.createCarModel(new ModelDTO("CX-5", ModelCategory.CAR, "https://avatars.mds.yandex.net/get-verba/1030388/2a000001874b5c98c9d4039e9b4b0e1827fb/cattouchret", 2022, 2021, brand14.getId())).getId();
        String model16 = modelService.createCarModel(new ModelDTO("911", ModelCategory.CAR, "https://images.drive.ru/i/0/60d2ca60745a9a38d75c2fa6.jpg", 2020, 2023, brand15.getId())).getId();
        String model17 = modelService.createCarModel(new ModelDTO("F-PACE", ModelCategory.CAR, "https://alfaleasing.ru/catalog-next/_next/image/?url=https://io.ilsa.ru/gallery/catalog/3/19/e416f188e869f67b3012bfb87968a193.jpeg&w=3840&q=70", 2020, 2021, brand16.getId())).getId();
        String model18 = modelService.createCarModel(new ModelDTO("Sport", ModelCategory.CAR, "https://avatars.mds.yandex.net/get-verba/1604130/2a000001808fae3ec46b9f65b1028c23f3c8/cattouchretcr", 2018, 2021, brand17.getId())).getId();
        String model19 = modelService.createCarModel(new ModelDTO("Model S", ModelCategory.CAR, "https://hips.hearstapps.com/hmg-prod/images/2024-tesla-model-s-107-6572200e43fa1.jpg?crop=0.473xw:0.355xh;0.254xw,0.341xh&resize=1200:*", 2010, 2021, brand18.getId())).getId();
        String model20 = modelService.createCarModel(new ModelDTO("XC60", ModelCategory.CAR, "https://vehicle-images.dealerinspire.com/fd01-110008903/YV4A22RL7M1727947/92b43c57e31abe7c48d1e7d16a586e2c.jpg", 2012, 2018, brand19.getId())).getId();

        UserRoleDTO userRole = userRoleService.createUserRole(new UserRoleDTO(UserRoleType.USER));
        UserRoleDTO adminRole = userRoleService.createUserRole(new UserRoleDTO(UserRoleType.ADMIN));

        String user1 = userService.createUser(new UserDTO("LadyBug", "user", "Marinette", "Dupain-Cheng", true, "/images/users/ladyBug.jpg")).getId();
        String user2 = userService.createUser(new UserDTO("MrPs", "password4", "Mr", "Ps", true, "/images/users/mrPs.jpg")).getId();
        String user3 = userService.createUser(new UserDTO("Never", "123456", "Rick", "Astley", true, "/images/users/rickAstley.jpg")).getId();
        String user4 = userService.createUser(new UserDTO("user", "user", "User", "User", true, "userImageUrl6")).getId();
        String user5 = userService.createUser(new UserDTO("username7", "password7", "User7", "Doe", true, "userImageUrl7")).getId();
        String user6 = userService.createUser(new UserDTO("username8", "password8", "User8", "Doe", false, "userImageUrl8")).getId();
        String user7 = userService.createUser(new UserDTO("username9", "password9", "User9", "Doe", true, "userImageUrl9")).getId();
        String user8 = userService.createUser(new UserDTO("username10", "password10", "User10", "Doe", true, "userImageUrl10")).getId();
        String user9 = userService.createUser(new UserDTO("username11", "password11", "User11", "Doe", false, "userImageUrl11")).getId();
        String user10 = userService.createUser(new UserDTO("username12", "password12", "User12", "Doe", true, "userImageUrl12")).getId();
        String user11 = userService.createUser(new UserDTO("username13", "password13", "User13", "Doe", true, "userImageUrl13")).getId();
        String user12 = userService.createUser(new UserDTO("username14", "password14", "User14", "Doe", true, "userImageUrl14")).getId();
        String user13 = userService.createUser(new UserDTO("username15", "password15", "User15", "Doe", false, "userImageUrl15")).getId();
        String user14 = userService.createUser(new UserDTO("username16", "password16", "User16", "Doe", false, "userImageUrl16")).getId();
        String user15 = userService.createUser(new UserDTO("username17", "password17", "User17", "Doe", true, "userImageUrl17")).getId();
        String user16 = userService.createUser(new UserDTO("username18", "password18", "User18", "Doe", true, "userImageUrl18")).getId();
        String user17 = userService.createUser(new UserDTO("username19", "password19", "User19", "Doe", true, "userImageUrl19")).getId();
        String user18 = userService.createUser(new UserDTO("username20", "password20", "User20", "Doe", true, "userImageUrl20")).getId();
        String admin = userService.createUser(new UserDTO("admin", "admin", "Admin", "Admin", true, "adminImageUrl", UserRoleType.ADMIN)).getId();

        OfferDTO offerDTO1 = offerService.createOffer(new OfferDTO("Все автомобили, представленные в продаже, проходят диагностику по всем параметрам, с результатами диагностики Вы можете ознакомиться при осмотре автомобиля."
                , EngineType.GASOLINE, "/images/offers/ToyotaCamry2019.png", 81341, new BigDecimal("2399000.00"), TransmissionType.AUTOMATIC, 2019, model1, user4));
        OfferDTO offerDTO2 = offerService.createOffer(new OfferDTO("Распродажа, финальный sale!\n\uD83D\uDCA5Гарантия 2 ГОДА или 100 000км пробега на ВСЕ НОВЫЕ автомобили BMW в РОЛЬФ Премиум Вешки!\uD83D\uDCA5"
                , EngineType.DIESEL, "/images/offers/BMWX52023.png", 0, new BigDecimal("15850000.00"), TransmissionType.AUTOMATIC, 2023, model2, user2));
        OfferDTO offerDTO3 = offerService.createOffer(new OfferDTO("Обслуживалась у официалов.\nПробег родной. Один хозяин.\nВ наличии комплект летней резины на дисках. Сигнализация с автозапуском."
                , EngineType.GASOLINE, "/images/offers/ToyotaCorolla2013.png", 101000, new BigDecimal("1500000.00"), TransmissionType.MANUAL, 2013, model3, admin));
        OfferDTO offerDTO4 = offerService.createOffer(new OfferDTO("Description4", EngineType.GASOLINE, "https://upload.wikimedia.org/wikipedia/commons/d/dc/Audi_A4_40_TFSI_B9_FL_Ibis_White_%281%29_%28cropped%29.jpg", 55000, new BigDecimal("10500.00"), TransmissionType.AUTOMATIC, 2017, model4, user3));
        OfferDTO offerDTO5 = offerService.createOffer(new OfferDTO("Description5", EngineType.DIESEL, "https://avatars.mds.yandex.net/get-verba/997355/2a00000176b7d3f6a4f92df665019bd8cd6f/cattouchret", 62000, new BigDecimal("15500.00"), TransmissionType.MANUAL, 2018, model5, user4));
        OfferDTO offerDTO6 = offerService.createOffer(new OfferDTO("Description6", EngineType.GASOLINE, "https://s.auto.drom.ru/i24222/c/photos/fullsize/ford/focus/ford_focus_821500.jpg", 59000, new BigDecimal("11000.00"), TransmissionType.AUTOMATIC, 2016, model6, user5));
        OfferDTO offerDTO7 = offerService.createOffer(new OfferDTO("Description7", EngineType.DIESEL, "https://images.drive.ru/i/0/5d565b07ec05c48d4d000003", 68000, new BigDecimal("16000.00"), TransmissionType.MANUAL, 2015, model7, user6));
        OfferDTO offerDTO8 = offerService.createOffer(new OfferDTO("Description8", EngineType.GASOLINE, "https://avatars.mds.yandex.net/get-verba/997355/2a0000016eb273ff6dd826c5442bfb75440e/cattouch", 51000, new BigDecimal("10000.00"), TransmissionType.AUTOMATIC, 2013, model8, user7));
        OfferDTO offerDTO9 = offerService.createOffer(new OfferDTO("Description9", EngineType.DIESEL, "https://s.auto.drom.ru/i24194/c/photos/fullsize/chevrolet/cruze/chevrolet_cruze_56042.jpg", 63000, new BigDecimal("15000.00"), TransmissionType.MANUAL, 2012, model9, user8));
        OfferDTO offerDTO10 = offerService.createOffer(new OfferDTO("Description10", EngineType.GASOLINE, "https://images.drive.ru/i/0/5eccec94ec05c4f93d000007.jpg", 57000, new BigDecimal("11500.00"), TransmissionType.AUTOMATIC, 2010, model10, user9));
        OfferDTO offerDTO11 = offerService.createOffer(new OfferDTO("Description11", EngineType.DIESEL, "https://motor.ru/thumb/1500x0/filters:quality(75):no_upscale()/imgs/2023/02/27/10/5811664/99f11856ba3f414c4fa0d24329cb097cfed2d51d.jpg", 61000, new BigDecimal("15500.00"), TransmissionType.MANUAL, 2008, model11, user10));
        OfferDTO offerDTO12 = offerService.createOffer(new OfferDTO("Description12", EngineType.GASOLINE, "https://data.favorit-motors.ru/upload/iblock/aef/aefb35e85c3f6976c95a21870d787dd3.jpg", 54000, new BigDecimal("10000.00"), TransmissionType.AUTOMATIC, 2006, model12, user11));
        OfferDTO offerDTO13 = offerService.createOffer(new OfferDTO("Description13", EngineType.DIESEL, "https://avatars.mds.yandex.net/get-autoru-vos/2127436/963825bd9ed0d030cbe07128799b0198/456x342n", 67000, new BigDecimal("16000.00"), TransmissionType.MANUAL, 2004, model13, user12));
        OfferDTO offerDTO14 = offerService.createOffer(new OfferDTO("Description14", EngineType.GASOLINE, "https://s.auto.drom.ru/i24234/c/photos/fullsize/lexus/rx350/lexus_rx350_897844.jpg", 52000, new BigDecimal("10500.00"), TransmissionType.AUTOMATIC, 2002, model14, user13));
        OfferDTO offerDTO15 = offerService.createOffer(new OfferDTO("Description15", EngineType.DIESEL, "https://avatars.mds.yandex.net/get-verba/1030388/2a000001874b5c98c9d4039e9b4b0e1827fb/cattouchret", 65000, new BigDecimal("15500.00"), TransmissionType.MANUAL, 2000, model15, user14));
        OfferDTO offerDTO16 = offerService.createOffer(new OfferDTO("Description16", EngineType.GASOLINE, "https://images.drive.ru/i/0/60d2ca60745a9a38d75c2fa6.jpg", 53000, new BigDecimal("11000.00"), TransmissionType.AUTOMATIC, 1998, model16, user15));
        OfferDTO offerDTO17 = offerService.createOffer(new OfferDTO("Description17", EngineType.DIESEL, "https://alfaleasing.ru/catalog-next/_next/image/?url=https://io.ilsa.ru/gallery/catalog/3/19/e416f188e869f67b3012bfb87968a193.jpeg&w=3840&q=70", 66000, new BigDecimal("16500.00"), TransmissionType.MANUAL, 1996, model17, user16));
        OfferDTO offerDTO18 = offerService.createOffer(new OfferDTO("Description18", EngineType.GASOLINE, "https://avatars.mds.yandex.net/get-verba/1604130/2a000001808fae3ec46b9f65b1028c23f3c8/cattouchretcr", 56000, new BigDecimal("10500.00"), TransmissionType.AUTOMATIC, 1994, model18, user17));
        OfferDTO offerDTO19 = offerService.createOffer(new OfferDTO("Description19", EngineType.DIESEL, "https://hips.hearstapps.com/hmg-prod/images/2024-tesla-model-s-107-6572200e43fa1.jpg?crop=0.473xw:0.355xh;0.254xw,0.341xh&resize=1200:*", 64000, new BigDecimal("15500.00"), TransmissionType.MANUAL, 1992, model19, user18));
        OfferDTO offerDTO20 = offerService.createOffer(new OfferDTO("Description20", EngineType.GASOLINE, "https://vehicle-images.dealerinspire.com/fd01-110008903/YV4A22RL7M1727947/92b43c57e31abe7c48d1e7d16a586e2c.jpg", 55000, new BigDecimal("10000.00"), TransmissionType.AUTOMATIC, 1990, model20, admin));

    }

    @Override
    public void run(String... args) throws Exception {


        createData(); // надо закомментить для показа реализации загрузки в кэш из базы

//        for (int i = 0; i < 10000; i++) {
//            brandService.createCarBrand("Brand №" + i);
//        }

//        System.out.println("Brand Model Counts:");
//        List<BrandModelCountDTO> brandModelCounts = brandService.getBrandModelCounts();
//        for (BrandModelCountDTO brandModelCount : brandModelCounts) {
//            System.out.println("Brand: " + brandModelCount.getName());
//            System.out.println("Model Count: " + brandModelCount.getСount());
//            System.out.println("---------------");
//        }
//
//        List<OfferDetailsDTO> offerDetails = offerService.getOfferDetails();
//
//        for (OfferDetailsDTO offerDetailsDTO : offerDetails) {
//            System.out.println(offerDetailsDTO.toString());
//            System.out.println();
//        }
//
//        List<UserDTO> users = userService.findUsersByRole(UserRoleType.USER);
//        System.out.println();
//        for (UserDTO user : users) {
//            System.out.println("User ID: " + user.getId());
//            System.out.println("Username: " + user.getUsername());
//            System.out.println();
//        }
//
//        List<OfferDetailsDTO> offerDTOS = offerService.getOfferDetailsByBrandName("Mazda");
//        System.out.println();
//        for (OfferDetailsDTO offerDetailsDTO1 : offerDTOS) {
//            System.out.println(offerDetailsDTO1.toString());
//            System.out.println();
//        }
//
//        List<OfferDetailsDTO> offerDTOS2 = offerService.getOfferDetailsByStartYear(2017);
//        System.out.println();
//        for (OfferDetailsDTO offerDetailsDTO : offerDTOS2) {
//            System.out.println(offerDetailsDTO.toString());
//            System.out.println();
//        }

    }
}

