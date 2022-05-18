package com.thikar.test_project_epoxy

import com.airbnb.epoxy.EpoxyController
import com.thikar.test_project_epoxy.databinding.RepaymentBucketBodyBinding
import com.thikar.test_project_epoxy.databinding.RepaymentBucketHeaderBinding
import com.thikar.test_project_epoxy.databinding.RepaymentsBucketRecommendedBinding

class BucketItemEpoxyController(
    val recommendedItem: RecommendedModel ,
    val creditItem:ArrayList<CreditZoneModel> ,
    val onItemClicked: (Int) -> Unit ,
    val viewModel:MainViewModel
):EpoxyController() {

  var isLoading:Boolean = true
    set(value){
        field = value
        if(field){
            requestModelBuild()
        }
    }

    override fun buildModels() {
        creditItem.forEachIndexed { index, creditZoneModel ->
            if(index == 0)
                BucketHeaderEpoxyModel(creditItem[index] ,onItemClicked ,viewModel).id("header").addTo(this)
            else
                BucketBodyEpoxyModel(creditItem[index] ,onItemClicked ,viewModel).id("body$index").addTo(this)
        }
        BucketRecommendedEpoxyModel(recommendedItem ,onItemClicked ,viewModel).id("recommended").addTo(this)
    }

    data class BucketHeaderEpoxyModel(
        val creditZoneItem:CreditZoneModel ,
        val onItemClicked: (Int) -> Unit ,
        val viewModel: MainViewModel
    ):
        ViewBindingKotlinModel<RepaymentBucketHeaderBinding>(R.layout.repayment_bucket_header){
        override fun RepaymentBucketHeaderBinding.bind() {

        }
    }

    data class BucketRecommendedEpoxyModel(
        val recommendedItem:RecommendedModel ,
        val onItemClicked: (Int) -> Unit ,
        val viewModel: MainViewModel
    ): ViewBindingKotlinModel<RepaymentsBucketRecommendedBinding>(R.layout.repayments_bucket_recommended){
        override fun RepaymentsBucketRecommendedBinding.bind() {

        }
    }

    data class BucketBodyEpoxyModel(
        val creditZoneItem:CreditZoneModel ,
        val onItemClicked: (Int) -> Unit ,
        val viewModel: MainViewModel
    ): ViewBindingKotlinModel<RepaymentBucketBodyBinding>(R.layout.repayment_bucket_body) {
        override fun RepaymentBucketBodyBinding.bind() {

        }
    }
}