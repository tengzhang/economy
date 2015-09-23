package com.economy.test;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * AbstractTestCase
 *
 * @author: zhangteng
 * @time: 14-1-15 下午4:56
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext*.xml"})
public class AbstractTestCase extends TestCase {
}
