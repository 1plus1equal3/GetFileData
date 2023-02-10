package com.example.lib;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyClass {

    public static String cookies = "tt_csrf_token=U6dQMjBu-fPCjGdPai6b1cv3ZL_-hdOSQxzU; ttwid=1%7CwTOthUrDytabpL3vmPIWhdvuGx3gTcgZO9H_ll6NSz4%7C1675997878%7C763d9d6a2b5658eed6570d5c2c6f80ff3f19e791a5e02232d3926fba4c109c10; tt_chain_token=sjUUG4jaDZQ7EtFhyw+6HQ==; tiktok_webapp_theme=light; __tea_cache_tokens_1988={%22_type_%22:%22default%22%2C%22user_unique_id%22:%227198356001493468674%22%2C%22timestamp%22:1675997843528}; csrf_session_id=dd9e593398ac00a92eac7b61931d40fc; bm_mi=B66255BA6F6ED21B6223A039B0704D94~YAAQbAqrcTM31jCGAQAApsHpORLUV/tzfHw56k74Sp9sLoFKvvf0alZYgNr4KPPbUhtDrYpOoPXloEk5q2LrmEYN5nkHVV948VGtcRpNLiMEsk0IvxEWGDvGwkcQ2pScWKyYzieppUXPlURTgZDxNogStb3ahFr1YTUKF7F2tZvMNIjoRYfzEK4QbhiqalZ8KHdM4rP+YbF7K4AtnZ3qUiVOl7EaKfD4dL+CFF+fD1zcJtV9Kp2ilAQvQFfkRq2VCySjbzgDQ3mg5X5iQJ6qMDEvDa+80QZJioI523Vxv6Ypg3lZp1R2RyM7kX8M2NRt7VJUB1oNub2QWlkUMu8uoPjQRRmcvJU7mWwvCo8=~1; _abck=695FAB950B679C7A64EDA87497AEB26B~0~YAAQNwurcTJmzjmGAQAAEdIfOgkYhain4MXRcebz4YZl4Jj+GEnIVTB2P8SBWVbtjhwevsMbEx+7d8aIRrwlYuFBUm87FMbHZME1rELEG3wVMDpLprRA2N9WTOOK4pR5e7KR0XBTehDkkTD4rdz87SBeTuw1DzEMlRFkrV/nvBCTC+FOin0hF75UPoafjg2CLqo0tKj2n7yye2xmPIaptELVwVBJxHj52+mKivHkMjJ5LnQveIcvZNOxXvCML/AinXbAdd9urlPjDWwgkprdQJ0LaB6Mo/QbFm+C4gB4eyzbDsObF4BpHGRg8sZbslgyBFWRVBL2Qz8oe/9NYjY1aj6BcnqKNVa1n4rSrjkXqfRyxLzd5BsfAz2RgPa4sldsGbMrwiJSWaVVJG+0zULstOevEjnuAIqY~-1~-1~-1; ak_bmsc=35B9ED77A9136FBE1B00359544F87524~000000000000000000000000000000~YAAQNwurcTNmzjmGAQAAEdIfOhKbRUWAzmlHjr85ZuY/v6Tmri3AN3MSl3vZpXcNgn/Ou3hN4E0YIMWyM9R5fz5TDMzVjGi4eCJkPzjkzprap+yQb5Egali5lCQmjAQFu7oJeFP0NI/qjny8JmTbvvumgSTjzTHzhWRqn05wwTi//FLDIsvwDNLljOz7JaOAl1wJmnQjzMp+RK/6LB12R+pK5zXG3CT7EYXGSZRSyRlu/T4XOJ12pQX69SpqJ+gTGHDOruqrsNeFZ+aH0vwPWgXSIw2tJY7LGpCD0G9iWzOXiahdwTOJ7dWq61RCd3mYP+xzYvlmVao6/WwttQEahHjrO1VBtRYhXL9z+SIgZcMBc8oWvL+ZHl+t2R4rgHKOc2ap+tFPtxBpp9cxwM/ThpyjvJIsoLOkQ5czaJ+ov5hSjEGKhZMd/LF/zx6bGU4C50eo/2DuN+e7RgUr; bm_sz=BB6640DAC92AD080C766618CC930FC8F~YAAQNwurcTVmzjmGAQAAEdIfOhIDIFVEvNhhdgHZ/clKgfRZ4PLtPCdNGQQd/2x4iIYHTK+Cai59kh/HQnm2En98D0yVJKFhLAMZ1SdHwlYoDw2zeep7VPUNSyCcX9UXnopB0ycW5eazMObJf4UplEw4JCFbdmHD7CJFvqJV/OF98G4Qla6Tmnnyy/vuJBkTlTCNX6p3EsJ0OdopAWI2TyQA8/2pyADd25l1DJJEnLy2AxxV6kf8h2NlQkqDuFwfGcyA4y7kZspgDfcLS4C7fV8h8dKECD0IAfUi+NYDZVyr5IU=~3553590~3684163; ttwid=1%7CwTOthUrDytabpL3vmPIWhdvuGx3gTcgZO9H_ll6NSz4%7C1676013477%7Cf62d1c3a4dfe312171925ed4079af39cb72f9f077c0f5405c19636f9162f98c6; bm_sv=DCDFC475CEEA02C7BEB95BA5CBC799A5~YAAQRwurcc3nzjmGAQAAlTIwOhJSopKDAyNmP6dY9RyZzJ6YiahZ5bmMdGYhAF5qd3AgmyMSNJhonOqHc1nq262UUVoCZkRBjVWow60mdMHAEqVMrJ9f3sTlO85taEC/YDG8iFCfoH7WSw20hQZp6zdm1RL5eumJlJs2l/NG/92L5P/EAPU71YShPXM3cvPhzyaKZRQ1AEX5JAoKKmwAYCoOStg0wg1qx6UugmHtmIL+hKYXHoN3/qHcz9PiQ3tMLg==~1; msToken=uQi5jBZpvMSRtH1zSXODXIfjL8CwW5ITnwAFsPvfkfJkypb9xeavi_OrVfghoBSLa-8O7bdNJeYOkGvAYJzYe8mox9Kcst9d3yqyXzffAfoGA_bPK7G-eHgvITijVFSkAMuhHQTom_Mol7ELoA==; msToken=uQi5jBZpvMSRtH1zSXODXIfjL8CwW5ITnwAFsPvfkfJkypb9xeavi_OrVfghoBSLa-8O7bdNJeYOkGvAYJzYe8mox9Kcst9d3yqyXzffAfoGA_bPK7G-eHgvITijVFSkAMuhHQTom_Mol7ELoA==";

    private static Map<String, String> buildCookiesMap(String cookieStr) {
        Map<String, String> cookieMap = new HashMap<>();
        String[] cookieArr = cookieStr.split("; ");
            Arrays.stream(cookieArr).forEach(cookie -> {
                String[] split = cookie.split("=", 2);
                cookieMap.put(split[0], split[1]);
                for (int i = 0; i < split.length - 1; i++) {
                    System.out.println(split[i] + ": " + split[i + 1]);
                }
            });
        return cookieMap;
    }

    public static void main(String[] args){
        Document doc;
        String url = "https://www.tiktok.com/@j7ayy/video/7197833337153670405";
        try {
            doc = Jsoup.connect(url)
                    .referrer("https://www.tiktok.com/")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36")
                    .cookies(buildCookiesMap(cookies))
                    .timeout(30000)
                    .get();
            System.out.println(doc.title());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}