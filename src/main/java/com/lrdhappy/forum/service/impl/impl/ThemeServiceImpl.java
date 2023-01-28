package com.lrdhappy.forum.service.impl.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lrdhappy.forum.bean.Theme;
import com.lrdhappy.forum.mapper.ThemeMapper;
import com.lrdhappy.forum.service.impl.ThemeService;
import org.springframework.stereotype.Service;

/**
 * @author lrd
 * @date 2023-01-28 16:42
 */
@Service
public class ThemeServiceImpl extends ServiceImpl<ThemeMapper, Theme> implements ThemeService {
}
