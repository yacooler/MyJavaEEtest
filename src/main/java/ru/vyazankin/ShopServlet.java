package ru.vyazankin;

import entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShopServlet", urlPatterns = "/shop")
public class ShopServlet extends HttpServlet {
    private StringBuilder builder;

    private static Logger logger = LoggerFactory.getLogger(ShopServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Log: GET");
        List<Product> products = getProductList();

        resp.setCharacterEncoding("UTF-8");

        builder.append("<html><body><meta charset=UTF-8></meta>");
        builder.append("<h3>Список продуктов в корзине</h3>");
        for (Product product: products) {
            builder.append(product.getId())
                    .append(") ")
                    .append(product.getTitle())
                    .append(" ")
                    .append(product.getCost().toString())
                    .append("<br>");
        }

        builder.append("</body></html>");

        resp.getWriter().printf(builder.toString());

        builder.setLength(0);
    }


    @Override
    public void destroy() {
        logger.debug("Destroy");
    }

    @Override
    public void init() throws ServletException {
        logger.debug("Init");
        builder = new StringBuilder();
    }

    private List<Product> getProductList(){
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Клавиатура Logitech", BigDecimal.valueOf(7000.00D)));
        products.add(new Product(2, "Мышь A4 R8", BigDecimal.valueOf(1700.00D)));
        products.add(new Product(3, "Монитор LG ULTRAWIDE34", BigDecimal.valueOf(27500.00D)));
        products.add(new Product(4, "Корпус", BigDecimal.valueOf(4390.00D)));
        products.add(new Product(5, "Материнская плата GIGABYTE", BigDecimal.valueOf(4630.00D)));
        products.add(new Product(6, "Оперативная память Kingstone 4*8GB", BigDecimal.valueOf(12900.00D)));
        products.add(new Product(7, "Процессор Xenon с Алиэкспресс", BigDecimal.valueOf(5390.00D)));
        products.add(new Product(8, "Видеокарта NVIDIA 1660TI", BigDecimal.valueOf(27800.00D)));
        products.add(new Product(9, "Блок питания 850W", BigDecimal.valueOf(4270.00D)));
        products.add(new Product(10, "Наклейка JAVA", BigDecimal.valueOf(00.50D)));
        return products;
    }

}