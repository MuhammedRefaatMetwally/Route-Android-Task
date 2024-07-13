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


fun ProductsEntity.toModel(): ProductsResponse {
    return ProductsResponse(
        skip = skip,
        total = total,
        products = products?.map { it?.toModel() },
        limit = limit,
    )
}

fun ProductsItemEntity.toModel(): ProductsItem {
    return ProductsItem(
        id = id,
        shippingInformation = shippingInformation,
        minimumOrderQuantity = minimumOrderQuantity,
        availabilityStatus = availabilityStatus,
        warrantyInformation = warrantyInformation,
        discountPercentage = discountPercentage,
        meta = meta?.toModel(),
        tags = tags,
        thumbnail = thumbnail,
        sku = sku,
        brand = brand,
        price = price,
        stock = stock,
        title = title,
        dimensions = dimensions?.toModel(),
        images = images,
        rating = rating,
        weight = weight,
        returnPolicy = returnPolicy,
        description = description,
        reviews = reviews?.map { it?.toModel() },
        category = category

    )
}

fun MetaEntity.toModel(): Meta {
    return Meta(
        createdAt = createdAt, qrCode = qrCode,
        barcode = barcode,
        updatedAt = updatedAt,
    )
}

fun DimensionsEntity.toModel(): Dimensions {
    return Dimensions(
        depth = depth,
        width = width,
        height = height,

        )
}

fun ReviewsItemEntity.toModel(): ReviewsItem {
    return ReviewsItem(
        rating = rating,
        date = date, reviewerName = reviewerName, reviewerEmail = reviewerEmail,
        comment = comment
    )
}