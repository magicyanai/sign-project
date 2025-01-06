package com.example.demo.model;

import com.example.demo.model.ShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingInfoRepository extends JpaRepository<ShippingInfo, Long> {

    // 根據訂單的 orderId 查詢物流信息
    List<ShippingInfo> findByOrderOrderId(Long orderId);

    // 根據多個訂單的 orderId 查詢物流信息
    List<ShippingInfo> findByOrderOrderIdIn(List<Long> orderIds);

    // 根據物流狀態查詢物流信息
    List<ShippingInfo> findByShippingInfoStatus(String shippingInfoStatus);

    // 根據收件人姓名查詢物流信息
    List<ShippingInfo> findByShippingInfoRecipient(String shippingInfoRecipient);

    // 根據訂單的 orderId 和物流狀態查詢物流信息
    List<ShippingInfo> findByOrderOrderIdAndShippingInfoStatus(Long orderId, String shippingInfoStatus);

    // 根據收件人姓名進行模糊查詢
    List<ShippingInfo> findByShippingInfoRecipientContaining(String partialRecipient);

    // 根據物流追蹤號查詢物流信息
    List<ShippingInfo> findByShippingInfoTrackingNumber(String trackingNumber);
}