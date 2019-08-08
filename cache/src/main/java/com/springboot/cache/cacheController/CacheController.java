package com.springboot.cache.cacheController;

import com.springboot.cache.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheManager cacheManager;

    @RequestMapping(value = "/save",method = {RequestMethod.POST,RequestMethod.GET},headers = "")
    public Map<Object,Object> putCache(@RequestBody Person person,@RequestParam int id) {
        Cache cache = cacheManager.getCache("cache-1");
        cache.put(person.getName(),person.getAge());
        Map<Object,Object> map =  new HashMap<>();
        map.put(person.getName(),person.getAge());
        return map;
    }
}
