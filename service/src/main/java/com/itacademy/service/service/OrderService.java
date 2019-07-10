package com.itacademy.service.service;

import com.itacademy.database.entity.Car;
import com.itacademy.database.entity.ClientOrder;
import com.itacademy.database.entity.User;
import com.itacademy.database.repository.CarRepository;
import com.itacademy.database.repository.OrderRepository;
import com.itacademy.database.repository.UserRepository;
import com.itacademy.service.dto.LeaseTImeDto;
import com.itacademy.service.dto.OrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final CarRepository carRepository;

    public List<ClientOrder> getAll() {
        return orderRepository.findAll();
    }

    public List<ClientOrder> getByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    public Optional<ClientOrder> getById(Long id) {
        return orderRepository.findById(id);
    }

    @Transactional
    public ClientOrder save(ClientOrder clientOrder) {
        return orderRepository.save(clientOrder);
    }

    @Transactional
    public void createOrder(OrderDto dto, LeaseTImeDto tImeDto) {
        try {
            User user = userRepository.getById(dto.getUserId());
            Car car = carRepository.getById(dto.getCarId());
            orderRepository.save(ClientOrder.builder()
                    .leaseDateAndTimeFrom(LocalDateTime.parse(tImeDto.getLeasePeriodStart()))
                    .leaseDateAndTimeTo(LocalDateTime.parse(tImeDto.getLeasePeriodEnd()))
                    .passportDetails(dto.getPassportDetails())
                    .adminApproval(false)
                    .user(user)
                    .build()
            );
            user.getCars().add(car);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
