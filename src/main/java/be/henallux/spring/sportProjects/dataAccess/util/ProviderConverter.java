package be.henallux.spring.sportProjects.dataAccess.util;

import be.henallux.spring.sportProjects.dataAccess.entity.*;
import be.henallux.spring.sportProjects.model.*;
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
    public TranslationEntity translationModelToTranslationEntity(Translation translation) {
        if(translation == null)
            return null;
        return new TranslationEntity(new TranslationPrimaryGroup(translation.getLanguageId(), translation.getProductId()), translation.getLabel());
    }

    public Translation translationEntityToTranslationModel(TranslationEntity translationEntity) {
        if(translationEntity == null)
            return null;

        return new Translation(translationEntity.getTranslationId().getLanguage(), translationEntity.getTranslationId().getProduct(), translationEntity.getLabel());
    }

    /*Language*/
    public LanguageEntity languageModelToLanguageEntity(Language language) {
        if(language == null)
            return null;
        return new LanguageEntity(language.getId(), language.getInternationCode());
    }

    public Language languageEntityToLanguageModel(LanguageEntity languageEntity) {
        if(languageEntity == null)
            return null;
        return new Language(languageEntity.getId(), languageEntity.getInternationCode());
    }


}
