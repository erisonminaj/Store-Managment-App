import { Component, OnInit } from "@angular/core";
import { Product } from "./product";
import { ProductService } from "./product.service";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})

export class ProductComponent implements OnInit {
  public products: Product[] = [];

  constructor(private productService: ProductService) {}

  ngOnInit(): void {

    this.productService.getProduct().subscribe(
      (data: Product[]) => {
        this.products = data;
      },
      (error) => {
        console.error('Error fetching Products data:', error);
      }
    );
  }
}
