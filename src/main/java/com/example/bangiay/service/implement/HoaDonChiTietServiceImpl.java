package com.example.bangiay.service.implement;

import com.example.bangiay.entity.HoaDonChiTiet;
import com.example.bangiay.repository.HoaDonChiTietRepository;
import com.example.bangiay.service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {
    @Autowired
    private HoaDonChiTietRepository repository;
    @Autowired
    private GiayChiTietServiceImpl giayChiTietService;

    @Override
    public List<HoaDonChiTiet> getall() {
        return repository.findAll();
    }

    @Override
    public HoaDonChiTiet add(HoaDonChiTiet hoaDonChiTiet) {
//        HoaDon invoice = hoaDonRepository.findById(hoaDonId)
//                .orElseThrow(() -> new ResourceNotFoundException("HoaDon not found with id " + hoaDonId));
//        GiayChiTiet shoeDetail = giayChiTietRepository.findById(giayChiTietId)
//                .orElseThrow(() -> new ResourceNotFoundException("GiayChiTiet not found with id " + giayChiTietId));

//        hoaDonChiTiet.setHoaDon(invoice);
//        hoaDonChiTiet.setGiayChiTiet(shoeDetail);
//        hoaDonChiTiet.setGiaNhap(shoeDetail.getGiay().getGiaNhap());
//        hoaDonChiTiet.setDonGia(shoeDetail.getGiay().getGiaBan());
        hoaDonChiTiet.setTrangThai(1);
        adjustStockQuantity(hoaDonChiTiet, false); // giảm số lượng khi tạo hóa đơn
        return repository.save(hoaDonChiTiet);
    }

    @Override
    public HoaDonChiTiet update(UUID id,HoaDonChiTiet updateOderDetails) {
        Optional<HoaDonChiTiet> optionalOrderDetails = repository.findById(id);
        if (optionalOrderDetails.isPresent()) {
            HoaDonChiTiet orderDetails = optionalOrderDetails.get();
            adjustStockQuantity(orderDetails, true); // tăng số lượng khi cập nhật hóa đơn (trả lại hàng cũ)
            // Cập nhật các trường của đơn hàng từ updatedOrderDetails
            // order.setXXX(updatedOrder.getXXX());
            orderDetails.setSoLuong(updateOderDetails.getSoLuong());
            orderDetails.setGiaNhap(updateOderDetails.getGiaNhap());
            orderDetails.setDonGia(updateOderDetails.getDonGia());
            orderDetails.setTrangThai(updateOderDetails.getTrangThai());
            adjustStockQuantity(orderDetails, false); // giảm số lượng khi cập nhập hóa đơn
            return repository.save(orderDetails);
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(UUID id) {
        Optional<HoaDonChiTiet> optionalOrderDetails = repository.findById(id);
        if (optionalOrderDetails.isPresent()) {
            adjustStockQuantity(optionalOrderDetails.get(), true); // tăng số lượng khi xóa hóa đơn (trả lại hàng)
            repository.delete(optionalOrderDetails.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Optional<HoaDonChiTiet> details(UUID id) {
        return repository.findById(id);
    }

    @Override
    public void adjustStockQuantity(HoaDonChiTiet hoaDonChiTiet, boolean isReturningStock) {
        giayChiTietService.updateStockQuantity(hoaDonChiTiet.getGiayChiTiet().getId(), hoaDonChiTiet.getSoLuong(), isReturningStock);

    }
}
