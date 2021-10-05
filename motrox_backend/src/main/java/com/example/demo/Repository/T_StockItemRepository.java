package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.T_StockItem;

@Repository
public interface T_StockItemRepository extends JpaRepository<T_StockItem,String >{
	
	

   
    
	//sukitha didi this.......
	
	//@Query(value = "SELECT * FROM stock WHERE item_name = :Item_Name", nativeQuery = true)
	//<T_StockItem> findT_StockItems(@Param("Item_Name")String Item_Name);

	
	
	   


}