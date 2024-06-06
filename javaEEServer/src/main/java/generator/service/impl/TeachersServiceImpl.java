package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.Teachers;
import generator.service.TeachersService;
import generator.mapper.TeachersMapper;
import org.springframework.stereotype.Service;

/**
* @author zjt
* @description 针对表【teachers】的数据库操作Service实现
* @createDate 2024-06-06 22:36:24
*/
@Service
public class TeachersServiceImpl extends ServiceImpl<TeachersMapper, Teachers> implements TeachersService{

}




