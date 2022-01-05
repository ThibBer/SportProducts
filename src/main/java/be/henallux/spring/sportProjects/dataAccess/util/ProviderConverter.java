package be.henallux.spring.sportProjects.dataAccess.util;

import be.henallux.spring.sportProjects.dataAccess.entity.*;
import be.henallux.spring.sportProjects.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProviderConverter {
    /*User*/
    public UserEntity userModelToUserEntity(User user){
        if(user == null)
            return null;

        UserEntity userEntity = new UserEntity(
                user.getId(),
                user.getEmail(),
                user.getFirstname(),
                user.getLastname(),
                user.getPhoneNumber(),
                user.getCity(),
                user.getPostalCode(),
                user.getStreet(),
                user.getHouseNumber(),
                user.getBirthDate(),
                user.getUsername(),
                user.getPassword(),
                user.getAuthoritiesString(),
                user.isAccountNonExpired(),
                user.isAccountNonLocked(),
                user.isCredentialsNonExpired(),
                user.isEnabled()
        );
        return userEntity;
    }

    public User userEntityToUserModel(UserEntity userEntity){
        if(userEntity == null)
            return null;

        User user = new User(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getFirstname(),
                userEntity.getLastname(),
                userEntity.getPhoneNumber(),
                userEntity.getCity(),
                userEntity.getPostalCode(),
                userEntity.getStreet(),
                userEntity.getHouseNumber(),
                userEntity.getBirthDate(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getAuthorities(),
                userEntity.getAccountNonExpired(),
                userEntity.getAccountNonLocked(),
                userEntity.getCredentialsNonExpired(),
                userEntity.getEnabled()
        );
        return user;
    }

    /*Category*/
    public CategoryEntity categoryModelToCategoryEntity(Category category){
        if(category == null){
            return null;
        }

        return new CategoryEntity(category.getId(), category.getLabel(), category.getDescription(), category.getImage(), promotionModelToPromotionEntity(category.getPromotion()));
    }

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity){
        if(categoryEntity == null){
            return null;
        }

        return new Category(categoryEntity.getId(), categoryEntity.getLabel(), categoryEntity.getDescription(), categoryEntity.getImage(), promotionEntityToPromotionModel(categoryEntity.getPromotion()));
    }
    
    public PromotionEntity promotionModelToPromotionEntity(Promotion promotion){
        if(promotion == null){
            return null;
        }

        return new PromotionEntity(promotion.getId(), promotion.getStartDate(), promotion.getEndDate(), promotion.getPercentage());
    }

    public Promotion promotionEntityToPromotionModel(PromotionEntity promotionEntity){
        if(promotionEntity == null){
            return null;
        }

        return new Promotion(promotionEntity.getId(), promotionEntity.getStartDate(), promotionEntity.getEndDate(), promotionEntity.getPercentage());
    }

    public ProductEntity productModelToProductEntity(Product product){
        if(product == null){
            return null;
        }

        return new ProductEntity(product.getId(), product.getPrice(), categoryModelToCategoryEntity(product.getCategory()), product.getDescription(), product.getImage());
    }

    public Product productEntityToProductModel(ProductEntity productEntity){
        if(productEntity == null){
            return null;
        }

        return new Product(productEntity.getId(), productEntity.getPrice(), categoryEntityToCategoryModel(productEntity.getCategoryEntity()), productEntity.getDescription(), productEntity.getImage());
    }

    /*Translation*/
    public Translation translationEntityToTranslationModel(TranslationEntity translationEntity) {
        if(translationEntity == null){
            return null;
        }

        return new Translation(translationEntity.getTranslationId().getLanguage(), translationEntity.getTranslationId().getProduct(), translationEntity.getLabel());
    }

    /*Language*/
    public Language languageEntityToLanguageModel(LanguageEntity languageEntity) {
        if(languageEntity == null){
            return null;
        }

        return new Language(languageEntity.getId(), languageEntity.getInternationCode());
    }

    public Order orderEntityToOrderModel(OrderEntity orderEntity){
        if(orderEntity == null)
            return null;

        return new Order(orderEntity.getId(), orderEntity.getDate(), userEntityToUserModel(orderEntity.getUserEntity()));
    }

    public OrderEntity orderModelToOrderEntity(Order order){
        if(order == null)
            return null;

        return new OrderEntity(order.getId(), order.getDate(), userModelToUserEntity(order.getUser()));
    }

    public OrderProductEntity orderProductModelToOrderProductEntity(OrderProduct orderProduct){
        if(orderProduct == null)
            return null;

        return new OrderProductEntity(orderProduct.getId(), orderProduct.getQuantity(), orderProduct.getAccordedPrice(), orderModelToOrderEntity(orderProduct.getOrder()), productModelToProductEntity(orderProduct.getProduct()));
    }

    public List<OrderProductEntity> orderProductModelsToOrderProductEntities(List<OrderProduct> orderProducts){
        if(orderProducts == null)
            return null;

        ArrayList<OrderProductEntity> orderProductEntities = new ArrayList<>();

        for(OrderProduct orderProduct: orderProducts){
            orderProductEntities.add(orderProductModelToOrderProductEntity(orderProduct));
        }

        return orderProductEntities;
    }
}
