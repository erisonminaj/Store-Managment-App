import {Component, OnInit} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {User} from "./user/User";
import {UserService} from "./user/user.service";


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

    this.userService.getUsers().subscribe(
      (data: User[]) => {
        this.users = data;
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
