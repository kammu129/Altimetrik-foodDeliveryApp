package com.altimetrik.foodfanda.controller;

import com.altimetrik.foodfanda.entity.Address;
import com.altimetrik.foodfanda.entity.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private static final String CUSTOMER_WITH_ADDRESS="{\"name\":\"Kamlesh\",\"location\":{\"locality\":\"Taramandal\",\"pinCode\":800001,\"houseNo\":\"4444\"},\"purchaseOrders\":null,\"cart\":null,\"reward\":null}";
    private static final String CUSTOMER_WITHOUT_ADDRESS="{\"name\":\"Kamlesh\",\"location\":null,\"purchaseOrders\":null}";
    private static final String ALL_CUSTOMERS="[{\"name\":\"kamlesh\",\"location\":null,\"purchaseOrders\":[],\"cart\":null,\"reward\":null},{\"name\":\"sanjay\",\"location\":{\"locality\":\"taramandal\",\"pinCode\":836452,\"houseNo\":\"444\"},\"purchaseOrders\":[],\"cart\":null,\"reward\":null},{\"name\":\"rami\",\"location\":{\"locality\":\"akashganga\",\"pinCode\":836457,\"houseNo\":\"445\"},\"purchaseOrders\":[],\"cart\":null,\"reward\":null},{\"name\":\"chamcham\",\"location\":{\"locality\":\"mars\",\"pinCode\":836457,\"houseNo\":\"445\"},\"purchaseOrders\":[],\"cart\":null,\"reward\":null}]\n";
    private static final String FIND_CUSTOMER_BY_LOCATION_ID="[{\"id\":\"d69e2dbc-1416-4a18-a301-c8c5248e4dd0\",\"name\":\"rami\",\"location\":{\"uuid\":\"7e2a0202-155c-4872-9811-4f5045168efc\",\"locality\":\"akashganga\",\"pinCode\":836457,\"houseNo\":\"445\"},\"purchaseOrders\":[],\"cart\":null,\"reward\":null}]";
    private static final String FIND_CUSTOMER_BY_ID="{\"id\":\"d69e2dbc-1416-4a18-a301-c8c5248e4dd0\",\"name\":\"rami\",\"location\":{\"uuid\":\"7e2a0202-155c-4872-9811-4f5045168efc\",\"locality\":\"akashganga\",\"pinCode\":836457,\"houseNo\":\"445\"},\"purchaseOrders\":[],\"cart\":null,\"reward\":null}";

    @Test
    public void create_customer_with_address() throws Exception {
        this.mockMvc.perform(post("/api/customer")
                .content(new ObjectMapper().writeValueAsString(Customer.builder().name("Kamlesh").
                        location(Address.builder().houseNo("4444").pinCode(800001)
                                .locality("Taramandal")
                                .build()).build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
        .andExpect(content().json(CUSTOMER_WITH_ADDRESS,false));
    }
    @Test
    public void create_customer() throws Exception {
        this.mockMvc.perform(post("/api/customer")
                .content(new ObjectMapper().writeValueAsString(Customer.builder().name("Kamlesh").build()))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
        .andExpect(content().json(CUSTOMER_WITHOUT_ADDRESS,false));
    }
    @Test
    public void findAll() throws Exception {
        this.mockMvc.perform(get("/api/customer")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
        .andExpect(content().json(ALL_CUSTOMERS,false))
        ;
    }
    @Test
    public void findByLocation() throws Exception {
        final UUID uuid = UUID.fromString("7e2a0202-155c-4872-9811-4f5045168efc");
        this.mockMvc.perform(get("/api/customer/location/"+uuid)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
        .andExpect(content().json(FIND_CUSTOMER_BY_LOCATION_ID,false))
        ;
    }

    @Test
    public void findById() throws Exception {
        final UUID uuid = UUID.fromString("d69e2dbc-1416-4a18-a301-c8c5248e4dd0");
        this.mockMvc.perform(get("/api/customer/"+uuid)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(FIND_CUSTOMER_BY_ID,false))
        ;
    }
}