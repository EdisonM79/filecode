/**  
 * <p>Title: ProductIdUtility.java</p>  
 * <p>Description: </p>  
 * @author Edison_M79 
 * @date 2018年9月7日  
 * @version 1.0  
 */  
package com.jzsk.filecode.utility;

import java.util.Random;

/**  
 * <p>Title: ProductIdUtility</p>  
 * <p>Description: </p>  
 * @author Edison_M79  
 * @date 2018年9月7日  
 */
public class FunctionIdUtility {
    
    /** 标识符 */
    private static final String ID = "FC";

    /** 字符源 */
    private static final String BASE_WORD = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * 生成productID
     * 
     * @return
     */
    public static String generateFunctionId() {

        String hexTime = Long.toHexString(DateUtility.getCurrentTimestamp().getTime()).toUpperCase();

        StringBuilder sb = new StringBuilder();
        sb.append(ID);
        sb.append(hexTime);

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int number = random.nextInt(BASE_WORD.length());
            sb.append(BASE_WORD.charAt(number));
        }
        return sb.toString();
    }
}
