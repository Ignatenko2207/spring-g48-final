package ua.mainacademy.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.mainacademy.controller.dto.OrderRequestDTO;
import ua.mainacademy.controller.dto.RequestDTO;
import ua.mainacademy.model.Item;
import ua.mainacademy.model.Order;
import ua.mainacademy.model.User;
import ua.mainacademy.service.OrderService;
import ua.mainacademy.service.UserService;

import java.util.Date;

import static java.util.Optional.ofNullable;

@Slf4j
@RestController
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PutMapping
    public ResponseEntity<Order> create(@RequestBody RequestDTO<OrderRequestDTO> orderRequest) {
        try {
            return new ResponseEntity<>(orderService.create(orderRequest.getData().getUserId()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
