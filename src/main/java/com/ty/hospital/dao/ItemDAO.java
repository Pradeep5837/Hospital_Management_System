package com.ty.hospital.dao;

import java.util.List;

import com.ty.hospital.dto.Item;

public interface ItemDAO {
	
	Item saveItem(int m_id,Item item);
	Item getItemById(int i_id);
	boolean deletItemById(int i_id);
	Item updateItemById(int i_id,Item item);
	List<Item> getAllItems();

}
