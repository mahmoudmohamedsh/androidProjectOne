package viewModels

import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel:ViewModel() {

    var shoesList = listOf<Shoe>()
    fun addNewShoe(shoe: Shoe){
       var temp =  shoesList + shoe
        shoesList = temp
    }
}