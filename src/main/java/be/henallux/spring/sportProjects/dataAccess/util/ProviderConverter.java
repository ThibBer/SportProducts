package be.henallux.spring.sportProjects.dataAccess.util;

import be.henallux.spring.sportProjects.dataAccess.entity.CategoryEntity;
import be.henallux.spring.sportProjects.dataAccess.entity.ProductEntity;
import be.henallux.spring.sportProjects.dataAccess.entity.PromotionEntity;
import be.henallux.spring.sportProjects.dataAccess.entity.UserEntity;
import be.henallux.spring.sportProjects.model.Category;
import be.henallux.spring.sportProjects.model.Product;
import be.henallux.spring.sportProjects.model.Promotion;
import be.henallux.spring.sportProjects.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class ProviderConverter {
    /*User*/
    public UserEntity userModelToUserEntity(User user){
        if(user == null){
            return new UserEntity();
        }
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
        if(userEntity == null){
            return new User();
        }

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

        return new CategoryEntity(category.getId(), category.getLabel(), category.getDescription(), promotionModelToPromotionEntity(category.getPromotion()));
    }

    public Category categoryEntityToCategoryModel(CategoryEntity categoryEntity){
        if(categoryEntity == null){
            return null;
        }

        return new Category(categoryEntity.getId(), categoryEntity.getLabel(), categoryEntity.getDescription(), promotionEntityToPromotionModel(categoryEntity.getPromotion()));
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

        return new ProductEntity(product.getId(), product.getPrice(), categoryModelToCategoryEntity(product.getCategory()), product.getDescription());
    }

    public Product productEntityToProductModel(ProductEntity productEntity){
        if(productEntity == null){
            return null;
        }

        return new Product(productEntity.getId(), productEntity.getPrice(), categoryEntityToCategoryModel(productEntity.getCategoryEntity()), productEntity.getDescription());
    }

    public ArrayList<ProductEntity> productModelsToProductEntities(Collection<Product> products){
/*        if(products == null){
            return null;
        }

        ArrayList<ProductEntity> productEntities = new ArrayList<>();

        for(Product product : products){
            productEntities.add(productModelToProductEntity(product));
        }

        return productEntities;*/

        return null;
    }

    public ArrayList<Product> productEntitiesToProductModels(Collection<ProductEntity> productEntities){
/*        if(productEntities == null){
            return null;
        }

        ArrayList<Product> productModels = new ArrayList<>();

        for(ProductEntity productEntity : productEntities){
            productModels.add(productEntityToProductModel(productEntity));
        }

        return productModels;*/

        return null;
    }
}
