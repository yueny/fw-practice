package com.yueny.fw.practice.manager;

import com.yueny.fw.practice.bo.CarBo;
import com.yueny.fw.practice.entry.CarEntry;
import com.yueny.superclub.api.pojo.IBo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * <code>
 *
 * </code>
 *
 * @author yueny09 <deep_blue_yang@163.com>
 * @DATE 2019/6/5 下午6:02
 */
@Mapper
public interface IService {
//    IService.INSTANCE
    //public IService INSTANCE = Mappers.getMapper(IService.class);

//    @Mapping(source = "numberOfSeats", target = "seatCount")
    @Mappings({})
    CarBo carToCarDto(CarEntry car);

//    public <T extends IBo> void mapper(CarEntry carDto, @MappingTarget T t);
}
