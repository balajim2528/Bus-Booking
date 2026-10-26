
import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-welcome',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './welcome.html',
  styleUrl: './welcome.css'
})
export class Welcome {
  private fb = inject(FormBuilder);
  private router = inject(Router);

  errorMessage = '';

  loginForm = this.fb.group({
    username: ['', Validators.required],
    password: ['', Validators.required]
  });

  onLogin(): void {
    if (this.loginForm.invalid) {
      this.loginForm.markAllAsTouched();
      return;
    }

    const { username, password } = this.loginForm.getRawValue();

    // Demo credentials only
    if (username === 'admin' && password === '1234') {
      this.router.navigate(['/passenger']);
    } else {
      this.errorMessage = 'Invalid username or password';
    }
  }
}
