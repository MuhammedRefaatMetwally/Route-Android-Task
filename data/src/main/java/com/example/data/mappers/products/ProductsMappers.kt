package com.example.data.mappers.products

import com.example.data.model.Dimensions
import com.example.data.model.Meta
import com.example.data.model.ProductsItem
import com.example.data.model.ProductsResponse
import com.example.data.model.ReviewsItem
import com.example.domain.products.model.DimensionsEntity
import com.example.domain.products.model.MetaEntity
import com.example.domain.products.model.ProductsEntity
import com.example.domain.products.model.ProductsItemEntity
import com.example.domain.products.model.ReviewsItemEntity


fun ProductsResponse.toEntity(): ProductsEntity {
    return ProductsEntity(
        skip = skip,
        limit = limit,
        total = total,
        products = products?.map { it?.toEntity() }
    )
}


fun ProductsItem.toEntity(): ProductsItemEntity {
    return ProductsItemEntity(
        id = id,
        shippingInformation = shippingInformation,
        minimumOrderQuantity = minimumOrderQuantity,
        availabilityStatus = availabilityStatus,
        warrantyInformation = warrantyInformation,
        discountPercentage = discountPercentage,
        meta = meta?.toEntity(),
        tags = tags,
        thumbnail = thumbnail,
        sku = sku,
        brand = brand,
        price = price,
        stock = stock,
        title = title,
        dimensions = dimensions?.toEntity(),
        images = images,
        rating = rating,
        weight = weight,
        returnPolicy = returnPolicy,
        description = description,
        reviews = reviews?.map { it?.toEntity() },
        category = category

    )
}

fun Meta.toEntity(): MetaEntity {
    return MetaEntity(
        createdAt = createdAt, qrCode = qrCode,
        barcode = barcode,
        updatedAt = updatedAt,
    )
}

fun Dimensions.toEntity(): DimensionsEntity {
    return DimensionsEntity(
        depth = depth,
        width = width,
        height = height,

        )
}

fun ReviewsItem.toEntity(): ReviewsItemEntity {
    return ReviewsItemEntity(
        rating = rating,
        date = date, reviewerName = reviewerName, reviewerEmail = reviewerEmail,
        comment = comment
    )
}


