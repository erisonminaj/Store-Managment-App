import {Component, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {User} from "./User";
import { HttpClient, HttpErrorResponse} from "@angular/common/http";
import {UserService} from "./user.service";
import {error} from "@angular/compiler-cli/src/transformers/util";

@Component({
  selector: 'app-root',
  standalone: false,
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'StorageMangmentApp';
  public users: User[] = [];

  constructor(private userService: UserService) {
  }

  ngOnInit(): void {
    // Call your service method to fetch user data from the backend
    this.userService.getUsers().subscribe(
      (data: User[]) => {
        this.users = data; // Assign fetched data to the users array
      },
      (error) => {
        console.error('Error fetching user data:', error);
      }
    );
  }

  createUser() {

  }

  searchUser() {

  }
}
