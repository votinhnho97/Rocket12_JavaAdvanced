package com.vti.BasicCRUD.utils;

import java.util.List;

public interface ICRUDUtils {
	/**
	 * Mở session
	 */
	void open();

	/**
	 * Đóng session
	 */
	void close();

	/**
	 * Lấy dữ liệu theo các cột định nghĩa trong {columns}, kết hợp với các tham số
	 * tùy chọn để thực hiện sắp xếp kết quả, paging, lọc
	 * 
	 * @param <T>
	 * @param entityClass : Entity.class
	 * @param columns     : Chuỗi tên các biến mapped với cột tương ứng đã cấu hình
	 *                    trong Entity, ví dụ: ["id", "name"]. Đặt là null để tìm
	 *                    chọn tất cả các cột.
	 * @param sortBy      : Tên biến mapped với cột dùng làm chỉ mục để sắp xếp
	 * @param sortType    : Kiểu sắp xếp, sortType = 0 = "ASC", sortType = 1 =
	 *                    "DESC"
	 * @param pageNumber  : Lấy kết quả ở trang số
	 * @param pageSize    : Giới hạn kết quả lấy ra
	 * @param searchBy    : Tên biến mapped với cột dùng để tìm kiếm / lọc
	 * @param searchType  : Kiểu tìm kiếm / lọc, ví dụ: searchType = "LIKE" hoặc
	 *                    searchType = "="
	 * @param searchValue : Giá trị để tìm kiếm / lọc
	 * @return List<Object>
	 */
	<T> List<?> findByColumns(Class<?> entityClass, String[] columns, String sortBy, int sortType, int pageNumber,
			int pageSize, String searchBy, String searchType, T searchValue);

	/**
	 * Lấy tất cả các cột trong Entity.
	 * 
	 * @param <T>
	 * @param entityClass : Entity.class
	 * @param sortBy      : Tên biến mapped với cột dùng làm chỉ mục để sắp xếp
	 * @param sortType    : Kiểu sắp xếp, sortType = 0 = "ASC", sortType = 1 =
	 *                    "DESC"
	 * @param pageNumber  : Lấy kết quả ở trang số
	 * @param pageSize    : Giới hạn kết quả lấy ra
	 * @param searchBy    : Tên biến mapped với cột dùng để tìm kiếm / lọc
	 * @param searchType  : Kiểu tìm kiếm / lọc, ví dụ: searchType = "LIKE" hoặc
	 *                    searchType = "="
	 * @param searchValue : Giá trị để tìm kiếm / lọc
	 * @return List<Object>
	 */
	<T> List<?> findAll(Class<?> entityClass, String sortBy, int sortType, int pageNumber, int pageSize,
			String searchBy, String searchType, T searchValue);

	/**
	 * Tạo 1 bản ghi mới
	 * 
	 * @param <T>
	 * @param newEntityObject
	 */
	<T> void create(T newEntityObject);

	/**
	 * Cập nhập 1 bản ghi
	 * 
	 * @param <T>
	 * @param entityObject
	 */
	<T> void update(T entityObject);

	/**
	 * Xóa 1 bản ghi
	 * 
	 * @param <T>
	 * @param entityObject
	 */
	<T> void delete(Class<T> entityClass, int id);
}
