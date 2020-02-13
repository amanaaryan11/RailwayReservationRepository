/*
 * package com.capg;
 * 
 * import static org.junit.Assert.assertEquals; import static
 * org.mockito.Mockito.when;
 * 
 * import java.sql.Date; import java.util.ArrayList; import java.util.List;
 * import java.util.stream.Collectors; import java.util.stream.Stream;
 * 
 * import org.junit.Test; import org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.context.SpringBootTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.test.context.junit4.SpringRunner;
 * 
 * import com.capg.beans.AccountDetails; import com.capg.beans.BookingDetails;
 * import com.capg.beans.TrainDetails; import com.capg.beans.User; import
 * com.capg.dao.IAccountRepository; import com.capg.dao.IBookingRepository;
 * import com.capg.dao.IRegisterRepository; import
 * com.capg.dao.ITrainRepository; import com.capg.dao.IUserRepoitory; import
 * com.capg.service.IAccountService; import com.capg.service.ITrainService;
 * 
 * @RunWith(SpringRunner.class)
 * 
 * @SpringBootTest public class SpringBankAppApplicationTests {
 * 
 * @Autowired IAccountService accountService;
 * 
 * @Autowired ITrainService trainService;
 * 
 * @MockBean IAccountRepository accountRepo;
 * 
 * @MockBean IBookingRepository bookingRepo;
 * 
 * @MockBean IRegisterRepository registerRepo;
 * 
 * @MockBean ITrainRepository trainRepo;
 * 
 * @MockBean IUserRepoitory userRepo;
 * 
 * AccountDetails accountDetails = new AccountDetails(1111111118l, 5999l,
 * 9887988798d);
 * 
 * BookingDetails bookingDdetails = new BookingDetails(76, 9887988798l);
 * 
 * TrainDetails trainDetails = new TrainDetails(12, 120013, "jain express",
 * "DELHI", "KOLKATA", new Date(2020 - 01 - 11), new Date(2020 - 01 - 13),
 * "12:00", "20:00", 88, 1200);
 * 
 * User user = new User(9887988767l, "pavankumar", "singh", "pk@gmail.com",
 * "User", 23, "pk123", 0);
 * 
 * List<User> list=new ArrayList<User>();
 * 
 * 
 * Integer balance=988798;
 * 
 * 
 * @Test public void addNewTrainDetails() {
 * when(trainRepo.save(trainDetails)).thenReturn(trainDetails);
 * assertEquals(trainDetails, trainRepo.save(trainDetails) ); }
 * 
 * 
 * 
 * 
 * @Test public void checkWalletBalanceExists() {
 * when(registerRepo.findWalletbalance(9887988798l)).thenReturn(balance);
 * assertEquals(balance, trainService.checkWalletBalanceExists(9887988798l)); }
 * 
 * @Test public void registerUserDetails() {
 * when(userRepo.save(user)).thenReturn(user); assertEquals(user,
 * userRepo.save(user) ); }
 * 
 * @Test public void getUserDetails() {
 * when(registerRepo.getUserDetails(8092244174l)).thenReturn(user);
 * assertEquals(user,registerRepo.getUserDetails(8092244174l) ); } }
 */