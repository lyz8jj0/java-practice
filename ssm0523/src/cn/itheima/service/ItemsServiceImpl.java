package cn.itheima.service;

import cn.itheima.mapper.ItemsMapper;
import cn.itheima.pojo.Items;
import cn.itheima.pojo.ItemsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsServiceImpl implements ItemsService{

    @Autowired(required = false)
    private ItemsMapper itemsMapper;


    @Override
    public List<Items> list() throws Exception {
        //如果不需要任何查询条件,直接将example对象new出来即可
        ItemsExample example = new ItemsExample();
        List<Items> list = itemsMapper.selectByExampleWithBLOBs(example);
        return list;
    }
}
