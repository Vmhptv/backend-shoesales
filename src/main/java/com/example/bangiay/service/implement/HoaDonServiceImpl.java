package com.example.bangiay.service.implement;

import com.example.bangiay.entity.*;
import com.example.bangiay.repository.*;
import com.example.bangiay.service.HoaDonChiTietService;
import com.example.bangiay.service.HoaDonService;
import com.example.bangiay.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class HoaDonServiceImpl implements HoaDonService {

    @Autowired
    private HoaDonRepository repository;
    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;
    @Autowired
    private GioHangRepository gioHangRepository;
    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepository;
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private GiayChiTietServiceImpl giayChiTietService;

    @Override
    public List<HoaDon> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<HoaDon> getOrderById(UUID id) {
        return  repository.findById(id);
    }

    @Override
    public List<HoaDon> getHoaDonByKhachHangId(UUID khachHangId) {
        return repository.findByKhachHangId(khachHangId);
    }

    @Override
    public HoaDon createOrder(HoaDon order,UUID khachHangId) {
        UUID hoaDonID = UUID.randomUUID();

        GioHang gioHang = gioHangRepository.findGioHangByKhachHangId(khachHangId);
        KhachHang khachHang = khachHangService.details(khachHangId);
        System.out.println(gioHang);
        List<GioHangChiTiet> gioHangChiTiets= gioHangChiTietRepository.findByGioHangId(gioHang.getId());

        if (gioHangChiTiets.isEmpty()) {
            throw new IllegalStateException("Giỏ hàng trống");
        }

        HoaDon hoaDon= new HoaDon();
       // hoaDon.setId(hoaDonID);
        hoaDon.setMa("HD24");
        hoaDon.setNgayTao(getCurrentTime());
        hoaDon.setNgayThanhToan(getCurrentTime());
        hoaDon.setMoTa(order.getMoTa());
        hoaDon.setTenNguoiNhan(order.getTenNguoiNhan());
        hoaDon.setSdtNguoiNhan(order.getSdtNguoiNhan());
        hoaDon.setDiaChi(order.getDiaChi());
        hoaDon.setHinhThucMua(1);
        hoaDon.setHinhThucThanhToan(order.getHinhThucThanhToan());
        hoaDon.setSoTienGiam(order.getSoTienGiam());
        hoaDon.setPhiShip(order.getPhiShip());
        hoaDon.setTrangThai(1);
        repository.save(hoaDon);

        hoaDon.setKhachHang(khachHang);

        List<HoaDonChiTiet> items = new ArrayList<>();
        System.out.println(items.size());
        // Bước 2: Sao chép các mục từ giỏ hàng vào bảng HoaDonChiTiet
        for (GioHangChiTiet gioHangChiTiet : gioHangChiTiets) {
            GiayChiTiet giayChiTiet = giayChiTietService.details(gioHangChiTiet.getGiayChiTiet().getId());

            System.out.println("đến đây chưa");

            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
            hoaDonChiTiet.setId(UUID.randomUUID());
            hoaDonChiTiet.setGiayChiTiet(giayChiTiet);
            hoaDonChiTiet.setSoLuong(gioHangChiTiet.getSoLuong());
            hoaDonChiTiet.setGiaNhap(giayChiTiet.getGiay().getGiaNhap());
            hoaDonChiTiet.setDonGia(giayChiTiet.getGiay().getGiaBan());
            hoaDonChiTiet.setTrangThai(1);

            hoaDonChiTietService.add(hoaDonChiTiet);
            items.add(hoaDonChiTiet);
            // Bước 3: Xóa các mục đã thanh toán khỏi bảng Giỏ Hàng Chi Tiết
//            gioHangChiTietRepository.deleteById(gioHangChiTiet.getId());
        }
        System.out.println(items.size());
        hoaDon.setItems(items);
        calculateTotalPrice(hoaDon);

        return repository.save(hoaDon);
    }

    @Override
    public HoaDon updateOrder(UUID id, HoaDon updatedOrder) {
        Optional<HoaDon> optionalOrder = repository.findById(id);
        if (optionalOrder.isPresent()) {
            HoaDon order = optionalOrder.get();
            adjustStockQuantity(order, true); // tăng số lượng khi cập nhật hóa đơn (trả lại hàng cũ)
            // Cập nhật các trường của đơn hàng từ updatedOrder
            // order.setXXX(updatedOrder.getXXX());
            order.setMa(updatedOrder.getMa());
            order.setNgayTao(updatedOrder.getNgayTao());
            order.setNgayThanhToan(updatedOrder.getNgayThanhToan());
            order.setMoTa(updatedOrder.getMoTa());
            order.setTenNguoiNhan(updatedOrder.getTenNguoiNhan());
            order.setSdtNguoiNhan(updatedOrder.getSdtNguoiNhan());
            order.setDiaChi(updatedOrder.getDiaChi());
            //order.setTongTien(updatedOrder.getTongTien());
            order.setHinhThucMua(updatedOrder.getHinhThucMua());
            order.setHinhThucThanhToan(updatedOrder.getHinhThucThanhToan());
            order.setHinhThucNhanHang(updatedOrder.getHinhThucNhanHang());
            order.setSoTienGiam(updatedOrder.getSoTienGiam());
            order.setPhiShip(updatedOrder.getPhiShip());
            order.setSoDiemSuDung(updatedOrder.getSoDiemSuDung());
            order.setSoTienQuyDoi(updatedOrder.getSoTienQuyDoi());
            order.setTrangThai(updatedOrder.getTrangThai());
            order.setItems(updatedOrder.getItems());
            adjustStockQuantity(order, false); // giảm số lượng khi cập nhật hóa đơn mới
            calculateTotalPrice(order);
            return repository.save(order);
        } else {
            return null;
        }
    }

    @Override
    public boolean deleteOrder(UUID id) {
        Optional<HoaDon> optionalOrder = repository.findById(id);
        if (optionalOrder.isPresent()) {
            adjustStockQuantity(optionalOrder.get(), true); // tăng số lượng khi xóa hóa đơn (trả lại hàng)
            repository.delete(optionalOrder.get());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void calculateTotalPrice(HoaDon order) {
        BigDecimal totalPrice  = BigDecimal.ZERO;
        for (HoaDonChiTiet item : order.getItems()) {
            item.setHoaDon(order);
            BigDecimal subtotal = BigDecimal.valueOf(item.getSoLuong()).multiply(item.getDonGia());
            totalPrice  = totalPrice.add(subtotal);
        }
        order.setTongTien(totalPrice);
    }

    @Override
    public void adjustStockQuantity(HoaDon order, boolean isReturningStock) {
        for (HoaDonChiTiet item : order.getItems()) {
            giayChiTietService.updateStockQuantity(item.getGiayChiTiet().getId(), item.getSoLuong(), isReturningStock);
            System.out.println(item.getGiayChiTiet().getId()+"VVVV"+item.getSoLuong()+"vvvv"+item.getSoLuong()+"abx"+isReturningStock);
        }
    }
    public static Date getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = formatter1.parse(now.format(formatter));
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }


    }
}
