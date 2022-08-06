package com.imaginnovate.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.imaginnovate.controller.UserController;
import com.imaginnovate.dto.UserDto;
import com.imaginnovate.entity.Address;
import com.imaginnovate.entity.User;
import com.imaginnovate.services.DtoService;

public class UserControllerTest {
	@InjectMocks
	UserController userController;
	
	@Mock
	DtoService dtoServices;
	
	 @Test
	    public void addUsersDetailsTest()
	    {
	        Address address = new Address(1,"kut","vishakapatnam",1234,"viz");

	        List<Address> usersAddress = new ArrayList<>();
	        usersAddress.add(address);

	        UserDto userDto = new UserDto(1,"susmitha","g","sus@gmail.com", usersAddress);
	        dtoService.saveUser(userDto); 
	        verify(dtoService, times(1)).saveUser(userDto);
	    }

	    @Test
	    public void getAllUsersTest()
	    {

	        Address address1 = new Address(1,"kut","vishakapatnam",1234,"viz");
	        Address address2 = new Address(2,"kut","vishakapatnam",1234,"viz");
	        Address address3 = new Address(3,"kut","vishakapatnam",1234,"viz");

	        List<Address> users1Address = new ArrayList<>();
	        users1Address.add(address3);
	        users1Address.add(address1);
	        User users1 = new User(1,"susmitha","g","sus@gmail.com", users1Address);

	        List<Address> users2Address = new ArrayList<>();
	        users2Address.add(address2);

	        User users2 = new User(2,"sunitha","g","sus@gmail.com", users2Address);

	        User users3 = new User(3,"sunitha","g","sus@gmail.com", users2Address);
	        List<User> list = new ArrayList<User>();
	        list.add(users1);
	        list.add(users2);
	        list.add(users3);
	        when(dtoService.getAllUsers()).thenReturn(list);
	        //test
	        List<User> usersList = dtoService.getAllUsers();
	        assertEquals(3, usersList.size());

	        verify(dtoService, times(1)).getAllUsers();
	    }

	    @Test
	    public void updateUsersDetailsTest()
	    {
	        Address address=new Address(1,"kut","vishakapatnam",1234,"viz");

	        List<Address> usersAddress=new ArrayList<>();
	        usersAddress.add(address);


	        UserDto userDto = new UserDto(1,"susmitha","g","sus@gmail.com",usersAddress);

	        dtoService.updateUser(userDto);

	        verify(dtoService, times(1)).updateUser(userDto);
	    }

	    @Test
	    public void getUserDetailsTest()
	    {

	        Address address1 = new Address(1,"kut","vishakapatnam",1234,"viz");

	        List<Address> users1Address = new ArrayList<>();
	        users1Address.add(address1);

	        Optional<User> users1 = Optional.of(new User());
	        when(dtoService.getUserDetails(1)).thenReturn(users1);

	        Optional<User> user=dtoService.getUserDetails(1);
	        assertEquals("susmitha", user.get().getName());
	        assertEquals(1, user.get().getId());
	    }

	

}
